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

    public void addMovies(Movie movie) {
        moviesDB.put(movie.getName(),movie);
        return ;
    }

    public void addDirector(Director director) {
        directorsDB.put(director.getName(),director);
        return;
    }

    public void addMovieDirectorPair(String movieName, String directorName) {
        if(!pairs.containsKey(directorName)){
            List<String> movieNamesOfDirector = new ArrayList<>();
            movieNamesOfDirector.add(movieName);
            pairs.put(directorName,movieNamesOfDirector);
            return;
        }
        List<String> movieNamesOfDirector=pairs.get(directorName);
        movieNamesOfDirector.add(movieName);
        pairs.put(directorName,movieNamesOfDirector);
        return;
    }

    public Movie getMovieByName(String name) {
        if(moviesDB.containsKey(name)){
            return moviesDB.get(name);
        }
        return null;
    }

    public Director getDirectorByName(String name) {
        if(directorsDB.containsKey(name)){
            return directorsDB.get(name);
        }
        return null;
    }

    public List<String> getMoviesByDirectorName(String director) {
        return pairs.get(director);
    }


    public List<String> findAllMovies() {
        List<String> allMovieNames = new ArrayList<>();
        for (String movieName : moviesDB.keySet()){
            allMovieNames.add(movieName);
        }
        return allMovieNames;
    }

    public void deleteDirectorByName(String name) {
        for(String directorName : pairs.keySet()){
            deleteDirectorByName(directorName);
        }
    }


    public void deleteAllDirectors() {
        for(String directorName : pairs.keySet()){
            deleteDirectorByName(directorName);
        }
    }
}
