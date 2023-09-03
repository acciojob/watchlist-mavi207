package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/movies/add-movie")
    public ResponseEntity addMovie(@RequestBody Movie movie){
        movieService.addMovies(movie);
        return ResponseEntity.ok("Movie added successfully");
    }

    @PostMapping("/movies/add-director")
    public ResponseEntity addDirector(@RequestBody Director director){
        movieService.addDirector(director);
        return ResponseEntity.ok("Director added successfully");
    }

    @PutMapping("/movies/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam("movieName") String movieName, @RequestParam("directorName") String directorName){
        movieService.addMovieDirectorPair(movieName,directorName);
        return ResponseEntity.ok("Pair added successfully");
    }

    @GetMapping("/movies/get-movie-by-name/{name}")
    public ResponseEntity getMovieByName(@PathVariable String name){
        Movie movie = movieService.getMovieByName(name);
        if(movie==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(movie);
    }

    @GetMapping("movies/get-director-by-name/{name}")
    public ResponseEntity getDirectorByName (@PathVariable String name){
        Director director=movieService.getDirectorByName(name);
        if(director==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(director);
    }

    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String director) {
        List<String> movies = movieService.getMoviesByDirectorName(director);
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies() {
        List<String> movies = movieService.findAllMovies();
        return ResponseEntity.ok(movies);
    }

    @DeleteMapping("/movies/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam("name") String name){
        movieService.deleteDirectorByName(name);
        return ResponseEntity.ok("Director and associated movies deleted successfully");
    }

    public ResponseEntity deleteAllDirectors(){
        movieService.deleteAllDirectors();
        return ResponseEntity.ok("All directors and associated movies deleted successfully");
    }
}
