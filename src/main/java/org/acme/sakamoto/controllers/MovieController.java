package org.acme.sakamoto.controllers;

import org.acme.sakamoto.models.Movie;
import org.acme.sakamoto.models.MultipartBody;
import org.acme.sakamoto.repositories.MovieRepository;
import org.acme.sakamoto.services.MovieService;
import org.acme.sakamoto.services.clients.MovieClientService;
import org.acme.sakamoto.services.clients.OpenMovieDatabaseClientService;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.ByteArrayInputStream;
import java.util.Base64;

@Path("/movies")
public class MovieController {

    @Inject
    MovieService service;
    @Inject
    MovieRepository repository;
    @Inject
    @RestClient
    OpenMovieDatabaseClientService movieDatabaseClientService;
    @Inject
    @RestClient
    MovieClientService movieClientService;

    private static final String apiKey = "ZDdiZGEwYTQ=";
    byte[] decodedBytes = Base64.getDecoder().decode(apiKey);
    String decodedString = new String(decodedBytes);

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
    @Path("find")
    @Produces(MediaType.APPLICATION_JSON)
    public Response find(@QueryParam("name") String name) {
        return Response.ok(movieDatabaseClientService.findMovie(name, decodedString)).build();
    }

    @GET
    @Path("search")
    @Produces(MediaType.APPLICATION_JSON)
    public Response search(@QueryParam("name") String name) {
        return Response.ok(movieDatabaseClientService.searchMovies(name, decodedString)).build();
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public String echoFile(String body) {
        return body;
    }

    @POST
    @Path("test")
    @Produces(MediaType.TEXT_PLAIN)
    public String callEcho() {
        final MultipartBody multipartBody = new MultipartBody();
        multipartBody.file = new ByteArrayInputStream("Hello world".getBytes());
        multipartBody.name = "hello.txt";
        return movieClientService.sendFile(multipartBody);
    }

}
