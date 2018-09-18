package com.example.dell.movies.View;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.dell.movies.App.Const;
import com.example.dell.movies.ContextModule;
import com.example.dell.movies.DaggerMovieComponent;
import com.example.dell.movies.MovieComponent;
import com.example.dell.movies.Network.ApiClient;
import com.example.dell.movies.Network.ApiService;
import com.example.dell.movies.Network.Model.Movie;
import com.example.dell.movies.Network.Model.Result;
import com.example.dell.movies.R;
import com.example.dell.movies.Utils.ColoumnsNumber;
import com.example.dell.movies.Utils.MovieListAdapter;
import com.example.dell.movies.Utils.RecyclerTouchListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import javax.annotation.Nullable;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class InTheater extends Fragment {

    @BindView(R.id.TheaterList)
    RecyclerView movieList;

    @BindView(R.id.Pb_Theater)
    ProgressBar waitForMe;

    ApiService apiService;
    CompositeDisposable disposable = new CompositeDisposable();
    MovieComponent movieComponent;
    ArrayList<Movie> movies = new ArrayList<>();
    MovieListAdapter adapter;
    Picasso picasso;
    private static final String MOVIES_KEY = "movies_key";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            movies = savedInstanceState.getParcelableArrayList(MOVIES_KEY);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tab_content, container, false);

        ButterKnife.bind(this, view);

        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), ColoumnsNumber.getColoumns(getContext()));

        movieComponent = DaggerMovieComponent.builder().contextModule(new ContextModule(getContext())).build();

        apiService = movieComponent.getApiService();
        picasso = movieComponent.getPicasso();

        adapter = new MovieListAdapter(getContext(), movies ,picasso);

        movieList.setLayoutManager(layoutManager);
        movieList.setAdapter(adapter);

        FetchMovies();

        movieList.addOnItemTouchListener(new RecyclerTouchListener(getContext(), movieList, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(getContext() , movies.get(position).getTitle() , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //disposable.dispose();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(MOVIES_KEY, movies);
    }

    public void FetchMovies() {
        if (movies.isEmpty()) {
            apiService.getInTheater(1)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(new DisposableObserver<Result>() {
                        @Override
                        public void onNext(Result result) {
                            movies.addAll(result.getMovies());
                        }

                        @Override
                        public void onError(Throwable e) {
                        }

                        @Override
                        public void onComplete() {
                            waitForMe.setVisibility(View.GONE);
                            adapter.notifyDataSetChanged();
                        }
                    });
        }
        if(!movies.isEmpty()){
            waitForMe.setVisibility(View.GONE);
        }

    }

}
