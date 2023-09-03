package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {

    HashMap<String,Movie> moviesDB=new HashMap<>();

    HashMap<String,Director> directorsDB=new HashMap<>();

    HashMap<String, List<String>> pairs=new HashMap<>();

    public void addMovie(Movie movie) {
        moviesDB.put(movie.getName(), movie);
    }

    public void addDirector(Director director) {
        directorsDB.put(director.getName(), director);
        directorsDB.put(director.getName(), director);
    }

    public void addMovieDirectorPair(String movieName, String directorName) {
        if(!pairs.containsKey(directorName)){
            List<String> movieNamesOfDirector = new ArrayList<>();
            movieNamesOfDirector.add(movieName);
            pairs.put(directorName,movieNamesOfDirector);
            return;
        }
        List<String> movieNamesOfDirector = pairs.get(directorName);
        movieNamesOfDirector.add(movieName);
        pairs.put(directorName,movieNamesOfDirector);
    }

    public Movie getMovieByName(String movieName) {
        return moviesDB.get(movieName);
    }

    public Director getDirectorByName(String directorName) {
        return directorsDB.get(directorName);
    }

    public List<String> getMoviesByDirectorName(String directorName) {
        return pairs.get(directorName);
    }

    public List<String> findAllMovies() {
        List<String> allMovieNames = new ArrayList<>();
        for (String movieName : moviesDB.keySet()){
            allMovieNames.add(movieName);
        }
        return allMovieNames;
    }

    public void deleteDirectorByName(String directorName) {
        List<String> allMoviesByDirector = pairs.get(directorName);
        for (String movieName : allMoviesByDirector){
            moviesDB.remove(movieName);
        }
        pairs.remove(directorName);
    }

    public void deleteAllDirectors() {
        for(String directorName : pairs.keySet()){
            deleteDirectorByName(directorName);
        }
    }

    public class Pair{
        Movie movie;
        Director director;

        public Pair(Movie movie, Director director) {
            this.movie = movie;
            this.director = director;
        }
    }
}