package ru.yastrebov.movies.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yastrebov.movies.model.Review;
import ru.yastrebov.movies.model.ReviewDTO;
import ru.yastrebov.movies.mupstruct.ReviewMapper;
import ru.yastrebov.movies.repository.ReviewRepository;
import ru.yastrebov.movies.service.ReviewService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;

    @Override
    public List<ReviewDTO> getAllReviews() {
        List<Review> reviewList = reviewRepository.findAll();

        return reviewList.stream()
                .map(reviewMapper::reviewToDto).collect(Collectors.toList());
    }

    @Override
    public List<ReviewDTO> getAllReviewsOfSomeMovie(Long movieId) {

        List<Review> allReviewsOfMovie = reviewRepository.findAllByMovieId(movieId);

        return allReviewsOfMovie.stream()
                .map(reviewMapper::reviewToDto).collect(Collectors.toList());
    }
}
