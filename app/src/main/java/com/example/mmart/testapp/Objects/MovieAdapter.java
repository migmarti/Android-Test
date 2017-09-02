package com.example.mmart.testapp.Objects;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.mmart.testapp.R;

/**
 * Created by MMART on 8/25/2017.
 */
public class MovieAdapter extends ArrayAdapter<Movies> {
    public MovieAdapter(Context context) {
        super(context, R.layout.movie_row, R.id.txtMovieName);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View objectView = super.getView(position, convertView, parent);

        TextView txtMovieName = (TextView) objectView.findViewById(R.id.txtMovieName);
        TextView txtMovieRuntime = (TextView) objectView.findViewById(R.id.txtMovieRuntime);
        TextView txtMovieDirector = (TextView) objectView.findViewById(R.id.txtMovieDirector);
        TextView txtMovieGenre = (TextView) objectView.findViewById(R.id.txtMovieGenre);
        TextView txtMovieRelease = (TextView) objectView.findViewById(R.id.txtMovieRelease);

        Movies objectMovie = this.getItem(position);
        txtMovieName.setText(objectMovie.getMovieName());
        txtMovieRuntime.setText(objectMovie.getRuntime());
        txtMovieDirector.setText(objectMovie.getDirector());
        txtMovieGenre.setText(objectMovie.getGenre());
        txtMovieRelease.setText(objectMovie.getReleaseDate());

        return objectView;
    }
}
