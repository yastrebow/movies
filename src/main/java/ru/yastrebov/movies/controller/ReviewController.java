package ru.yastrebov.movies.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.yastrebov.movies.api.ReviewApi;
import ru.yastrebov.movies.model.ReviewDTO;
import ru.yastrebov.movies.service.ReviewService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReviewController implements ReviewApi {

    private final ReviewService reviewService;

    @Override
    public ResponseEntity<List<ReviewDTO>> getAllReviews() {
        return ResponseEntity.ok(reviewService.getAllReviews());

    }

    @Override
    public ResponseEntity<List<ReviewDTO>> getReviewsAboutSomeMovie(@PathVariable Long movieId) {


        return ResponseEntity.ok(reviewService.getAllReviewsOfSomeMovie(movieId));
    }

}
