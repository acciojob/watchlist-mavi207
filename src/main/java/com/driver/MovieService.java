package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;
    public void addMovies(Movie movie) {
        movieRepository.addMovies(movie);
        return;
    }

    public void addDirector(Director director) {
        movieRepository.addDirector(director);
        return;
    }

    public void addMovieDirectorPair(String movieName, String directorName) {
        movieRepository.addMovieDirectorPair(movieName,directorName);
    }

    public Movie getMovieByName(String name) {
        return movieRepository.getMovieByName(name);
    }

    public Director getDirectorByName(String name) {
        return movieRepository.getDirectorByName(name);
    }

    public List<String> getMoviesByDirectorName(String director) {
        return movieRepository.getMoviesByDirectorName(director);
    }

    public List<String> findAllMovies() {
        return movieRepository.findAllMovies();
    }

    public void deleteDirectorByName(String name) {
        movieRepository.deleteDirectorByName(name);
    }

    public void deleteAllDirectors() {
        movieRepository.deleteAllDirectors();
    }
}
