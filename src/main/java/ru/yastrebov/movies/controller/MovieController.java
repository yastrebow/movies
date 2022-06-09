package ru.yastrebov.movies.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.yastrebov.movies.api.MoviesApi;
import ru.yastrebov.movies.exception.handler.WrongArgumentException;
import ru.yastrebov.movies.model.MovieDTO;
import ru.yastrebov.movies.service.MovieService;

@RestController
@RequiredArgsConstructor
public class MovieController implements MoviesApi {

    private final MovieService service;

    @Override
    public ResponseEntity<Page<MovieDTO>> getListOfMovies(Integer first, Integer skip) throws WrongArgumentException {

        if (skip < first) {
            throw new WrongArgumentException();
        } else if ((skip % first) != 0) {
            throw new WrongArgumentException();
        } else {
            return ResponseEntity.ok(service.getListOfMovies(first, skip));
        }
    }
}
