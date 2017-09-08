package com.example.mmart.testapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.mmart.testapp.Objects.MovieAdapter;
import com.example.mmart.testapp.Objects.Movies;

import java.util.ArrayList;

public class MovieListActivity extends AppCompatActivity {
    MovieAdapter movieAdapter;
    ListView listView;
    ArrayList<Movies> listMovies;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);
        listView = (ListView) findViewById(R.id.lv_movieList);
        movieAdapter = new MovieAdapter(this);
        listView.setAdapter(movieAdapter);

        listMovies = this.getIntent().getParcelableArrayListExtra("Parcel");
        //objectMovie.getMovieName();

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

    @Override
    public void onBackPressed() {
        codeReturn();
    }

    public void codeReturn() {
        Intent intent = new Intent();
        listMovies = new ArrayList<Movies>();
        for(int i = 0; i < movieAdapter.getCount(); i++){
            listMovies.add(movieAdapter.getItem(i));
        }
        intent.putExtra("ReturnParcel", listMovies);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

    private void fillMovieDatabase(ArrayList<Movies> listMovies) {
        movieAdapter.clear();
        for (Movies movie : listMovies) {
            movieAdapter.add(movie);
        }
        movieAdapter.notifyDataSetChanged();
    }
}
