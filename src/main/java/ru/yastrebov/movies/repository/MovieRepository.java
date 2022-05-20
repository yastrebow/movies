package ru.yastrebov.movies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yastrebov.movies.model.Movie;
import ru.yastrebov.movies.model.MovieDTO;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{


}
