package ru.yastrebov.movies.service;

import ru.yastrebov.movies.model.MovieDTO;

import java.util.List;

public interface MovieService {

    List<MovieDTO> getListOfMovies(Integer first, Integer skip);
}
