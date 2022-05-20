package ru.yastrebov.movies.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.yastrebov.movies.api.MoviesApi;
import ru.yastrebov.movies.model.MovieDTO;
import ru.yastrebov.movies.service.MovieService;

import java.util.List;

@RestController
public class MovieController implements MoviesApi {

    private final MovieService service;

    public MovieController(MovieService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<List<MovieDTO>> getListOfMovies(Integer first, Integer skip) {
        return ResponseEntity.ok(service.getListOfMovies(first, skip));
    }
}
