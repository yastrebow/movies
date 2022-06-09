package ru.yastrebov.movies.mupstruct;

import org.mapstruct.BeanMapping;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueMappingStrategy;
import ru.yastrebov.movies.model.Movie;
import ru.yastrebov.movies.model.MovieDTO;

@Mapper(componentModel = "spring",
        builder = @Builder(disableBuilder = true))
public interface MovieMapper {

    MovieDTO movieToDto(Movie movie);

    Movie dtoToMovie(MovieDTO movieDTO);

    @BeanMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
    void updateFromDtoToMovie(MovieDTO movieDTO, @MappingTarget Movie movie);
}
