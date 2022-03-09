package ro.fasttrackit.curs21.homework.service;

import org.springframework.stereotype.Service;
import ro.fasttrackit.curs21.homework.model.Movie;
import ro.fasttrackit.curs21.homework.repository.MovieRepository;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository repository;

    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }

    public List<Movie> getMovies() {
        return repository.findAll();
    }
}
