package org.acme.sakamoto.services.clients;

import org.acme.sakamoto.models.Movie;
import org.acme.sakamoto.models.MovieSearchResponse;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@RegisterRestClient(baseUri = "http://www.omdbapi.com/")
public interface OpenMovieDatabaseClientService {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    MovieSearchResponse searchMovies(@QueryParam("s") String search, @QueryParam("apikey") String apiKey);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Movie findMovie(@QueryParam("t") String title, @QueryParam("apikey") String apiKey);
}
