package com.kajendra.dashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupMoviesViewPager();
    }

    private void setupMoviesViewPager() {
        ViewPager2 movieViewPager = findViewById(R.id.moviesViewPager);
        movieViewPager.setClipToPadding(false);
        movieViewPager.setClipChildren(false);
        movieViewPager.setOffscreenPageLimit(3);
        movieViewPager.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(10));
        compositePageTransformer.addTransformer((page, position) -> {
            float r = 1 - Math.abs(position);
            page.setScaleY(0.85f + r * 0.15f);
        });

        movieViewPager.setPageTransformer(compositePageTransformer);
        movieViewPager.setAdapter(new MoviesAdapter(getMovies()));
    }

    private List<Movie> getMovies() {
        List<Movie> movies = new ArrayList<>();

        Movie movieone = new Movie();
        movieone.poster = R.drawable.movie_1;
        movieone.name = "Mulan";
        movieone.category = "Fantasy";
        movieone.releaseDate = "August 12, 2021";
        movieone.rating = 5.0f;
        movies.add(movieone);

        Movie movietwo = new Movie();
        movietwo.poster = R.drawable.movie_2;
        movietwo.name = "Shershaah";
        movietwo.category = "Action";
        movietwo.releaseDate = "August 12, 2021";
        movietwo.rating = 4.9f;
        movies.add(movietwo);

        Movie moviethree = new Movie();
        moviethree.poster = R.drawable.movie_3;
        moviethree.name = "Jurassic World: Fallen Kingdom";
        moviethree.category = "Science Fiction";
        moviethree.releaseDate = "June 7, 2018";
        moviethree.rating = 4.1f;
        movies.add(moviethree);

        Movie moviefour = new Movie();
        moviefour.poster = R.drawable.movie_4;
        moviefour.name = "The Conjuring: The Devil Made Me Do It";
        moviefour.category = "Horror";
        moviefour.releaseDate = "May 26, 2021";
        moviefour.rating = 4.1f;
        movies.add(moviefour);

        return movies;

    }
}