package ru.yastrebov.movies.mupstruct;

import org.mapstruct.*;
import ru.yastrebov.movies.model.Review;
import ru.yastrebov.movies.model.ReviewDTO;

@Mapper(componentModel = "spring",
        builder = @Builder(disableBuilder = true))
public interface ReviewMapper {

    ReviewDTO reviewToDto(Review review);

    Review dtoToReview(ReviewDTO reviewDTO);

    @BeanMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
    void updateFromDtoToReview(ReviewDTO reviewDTO, @MappingTarget Review review);
}
