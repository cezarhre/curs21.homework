package ro.fasttrackit.curs21.homework.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.fasttrackit.curs21.homework.model.Movie;
import ro.fasttrackit.curs21.homework.service.MovieService;

import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {

    private final MovieService service;

    public MovieController(MovieService service) {
        this.service = service;
    }

    @GetMapping
    List<Movie> getMovies(){
        return service.getMovies();
    }
}
