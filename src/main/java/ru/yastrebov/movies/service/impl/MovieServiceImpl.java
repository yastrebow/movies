package ru.yastrebov.movies.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yastrebov.movies.model.Movie;
import ru.yastrebov.movies.model.MovieDTO;
import ru.yastrebov.movies.mupstruct.MovieMapper;
import ru.yastrebov.movies.repository.MovieRepository;
import ru.yastrebov.movies.service.MovieService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    @Override
    public List<MovieDTO> getListOfMovies(Integer first, Integer skip) {
        List<Movie> listOfAllMovies = movieRepository.findAll();

        return listOfAllMovies
                .stream()
                .skip(skip)
                .limit(first)
                .map(movieMapper::entityToDto)
                .collect(Collectors.toList());
    }
}
