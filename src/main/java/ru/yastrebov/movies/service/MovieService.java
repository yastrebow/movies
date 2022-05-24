package ru.yastrebov.movies.service;

import org.springframework.data.domain.Page;
import ru.yastrebov.movies.model.MovieDTO;

public interface MovieService {

    Page<MovieDTO> getListOfMovies(Integer first, Integer skip);
}
