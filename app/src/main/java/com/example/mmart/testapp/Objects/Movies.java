package com.example.mmart.testapp.Objects;

/**
 * Created by MMART on 8/25/2017.
 */
public class Movies {
    private String movieName;
    private String runtime;
    private String director;
    private String genre;
    private String releaseDate;

    public Movies(String movieName, String runtime, String director, String genre, String releaseDate) {
        this.movieName = movieName;
        this.runtime = runtime;
        this.director = director;
        this.genre = genre;
        this.releaseDate = releaseDate;
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
}
