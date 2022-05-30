package ru.yastrebov.movies.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "release")
    String release;

    @Column(name = "title")
    String title;

    @OneToMany(mappedBy = "movie", fetch = FetchType.LAZY)
    private List<Review> reviewList;
}
