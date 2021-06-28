package org.acme.sakamoto.repositories;

import org.acme.sakamoto.models.Movie;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class MovieRepository implements Repository<Movie> {

    private List<Movie> movies = new ArrayList<>();

    @Override
    public Movie add(Movie entity) {
        entity.setId(movies.size() + 1);
        movies.add(entity);
        return entity;
    }

    @Override
    public Movie update(int id, Movie entity) {
        movies.set(id - 1, entity);
        return entity;
    }

    @Override
    public void delete(int id) {
        movies.remove(id - 1);
    }

    @Override
    public Movie findById(int id) {
        return movies.get(id + 1);
    }

    public List<Movie> list() {
        return movies;
    }

    public Movie findByName(String name) {
        return movies.stream()
                .filter(movie -> movie.getTitle().equals(name))
                .findFirst()
                .orElse(new Movie());
    }

    public List<Movie> findByAuthor(String author) {
        return movies.stream()
                .filter(movie -> movie.getGenre().equals(author))
                .collect(Collectors.toList());
    }
}
