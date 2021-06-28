package org.acme.sakamoto.controllers;

import org.acme.sakamoto.models.Movie;
import org.acme.sakamoto.repositories.MovieRepository;
import org.acme.sakamoto.services.MovieService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("movies")
public class MovieController {

    @Inject
    MovieService service;
    @Inject
    MovieRepository repository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Movie addMovie(Movie movie) {
        return service.add(movie);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Movie updateMovie(@PathParam("id") int id, Movie movie) {
        return service.update(id, movie);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMovies() {
        return Response.ok(repository.list()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response find(@QueryParam("name") String name) {

        return null;
    }
}
