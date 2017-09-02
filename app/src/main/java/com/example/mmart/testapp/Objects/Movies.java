package com.example.mmart.testapp.Objects;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by MMART on 8/25/2017.
 */
public class Movies implements Parcelable {
    private String movieName;
    private String runtime;
    private String director;
    private String genre;
    private String releaseDate;

    public Movies() {}

    public Movies(String movieName, String runtime, String director, String genre, String releaseDate) {
        this.movieName = movieName;
        this.runtime = runtime;
        this.director = director;
        this.genre = genre;
        this.releaseDate = releaseDate;
    }

    public Movies(Parcel in) {
        movieName = in.readString();
        runtime = in.readString();
        director = in.readString();
        genre = in.readString();
        releaseDate = in.readString();
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(movieName);
        dest.writeString(runtime);
        dest.writeString(director);
        dest.writeString(genre);
        dest.writeString(releaseDate);
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator(){
            public Movies createFromParcel(Parcel in){
                return new Movies(in);
            }
            public Movies[] newArray(int size) {
                return new Movies[size];
            }
    };
}
