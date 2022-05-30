package ru.yastrebov.movies.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.yastrebov.movies.model.MovieDTO;
import ru.yastrebov.movies.mupstruct.MovieMapper;
import ru.yastrebov.movies.repository.MovieRepository;
import ru.yastrebov.movies.service.MovieService;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    @Override
    public Page<MovieDTO> getListOfMovies(Integer first, Integer skip) {

        int skipPages = skip / first;

        return movieRepository.findAll(PageRequest.of(skipPages, first)).map(movieMapper::movieToDto);
    }
}

