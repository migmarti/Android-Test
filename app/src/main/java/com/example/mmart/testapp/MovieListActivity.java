package com.example.mmart.testapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.mmart.testapp.Objects.MovieAdapter;
import com.example.mmart.testapp.Objects.Movies;

import java.util.ArrayList;

public class MovieListActivity extends AppCompatActivity {
    static ArrayList<Movies> listMovies = new ArrayList<Movies>();
    MovieAdapter movieAdapter;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);
        listView = (ListView) findViewById(R.id.lv_movieList);
        movieAdapter = new MovieAdapter(this);
        listView.setAdapter(movieAdapter);
//        for (int i = 0; i < 10; i++) {
//            Movies movie = new Movies(
//                    "Movie Name " + i,
//                     i + ":00",
//                    "Director Name " + i,
//                    "Genre " + i,
//                     i + "/" + i + "/" + i);
//            listMovies.add(movie);
//        }
        fillMovieDatabase(listMovies);
    }

    private void fillMovieDatabase(ArrayList<Movies> listMovies) {
        movieAdapter.clear();
        for (Movies movie : listMovies) {
            movieAdapter.add(movie);
        }
        movieAdapter.notifyDataSetChanged();
    }
}
