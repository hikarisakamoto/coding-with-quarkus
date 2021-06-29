package org.acme.sakamoto.services;

import org.acme.sakamoto.models.Movie;
import org.acme.sakamoto.repositories.MovieRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class MovieService implements Service<Movie> {

    @Inject
    MovieRepository repository;

    @Override
    public Movie add(Movie entity) {
        return repository.add(entity);
    }

    @Override
    public Movie update(int id, Movie entity) {
        return repository.update(id, entity);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }
}
