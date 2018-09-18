package com.example.dell.movies.View;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.dell.movies.ContextModule;
import com.example.dell.movies.MovieComponent;
import com.example.dell.movies.Network.ApiService;
import com.example.dell.movies.R;
import com.example.dell.movies.Utils.SectionsPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.my_toolbar)
    Toolbar toolbar;

    @BindView(R.id.tabs_view)
    TabLayout tabsLayouts;

    @BindView(R.id.my_viewpager)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSupportActionBar(toolbar);

        ButterKnife.bind(this);

        viewPager.setOffscreenPageLimit(4);

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(sectionsPagerAdapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabsLayouts));
        tabsLayouts.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));

    }
}
