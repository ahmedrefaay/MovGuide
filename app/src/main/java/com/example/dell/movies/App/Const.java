package com.example.dell.movies.App;

import com.example.dell.movies.BuildConfig;

public class Const {

    private static final String BASE_URL = "https://api.themoviedb.org/3/";

    private static final String LANGUAGE_STRING = "en-US";

    private static final String ISO3661_REGION = "US";

    private static final String BASE_POSTER_PATH = "http://image.tmdb.org/t/p/w342";

    private static final String BASR_BACKDROP_PATH = "http://image.tmdb.org/t/p/w780";

    private static final String API_KEY = "0ab274d55fc092cc6c2da97da7b58e67";

    private static final String Sort_BY_POPULARITY = "popularity.desc";

    private static final String Sort_BY_VOTE = "vote_average.desc";


    public static String getBaseUrl() {
        return BASE_URL;
    }

    public static String getBasePosterPath(String PosterPath) {
        return BASE_POSTER_PATH + PosterPath;
    }

    public static String getBaseBackdropPath(String BackDropPath) {
        return BASR_BACKDROP_PATH + BackDropPath;
    }

    public static String getApiKey() {
        return API_KEY;
    }

    public static String getLanguageString() {
        return LANGUAGE_STRING;
    }

    public static String getIso3661Region() {
        return ISO3661_REGION;
    }

    public static String getSort_BY_POPULARITY() {
        return Sort_BY_POPULARITY;
    }

    public static String getSort_BY_VOTE() {
        return Sort_BY_VOTE;
    }


}
