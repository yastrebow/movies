package ru.yastrebov.movies.service;

import ru.yastrebov.movies.model.ReviewDTO;

import java.util.List;

public interface ReviewService {

    List<ReviewDTO> getAllReviews();

    List<ReviewDTO> getAllReviewsOfSomeMovie(Long movieId);
}
