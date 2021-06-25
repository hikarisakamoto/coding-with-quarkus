package org.acme.sakamoto.controllers;

import org.acme.sakamoto.models.Book;
import org.acme.sakamoto.repositories.BookRepository;
import org.acme.sakamoto.services.BookService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("books")
public class BookController {

    @Inject
    BookService service;
    @Inject
    BookRepository repository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Book addBook(Book book) {
        return service.add(book);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Book updateBook(@PathParam("id") int id, Book book) {
        return service.update(id, book);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBooks() {
        return Response.ok(repository.list()).build();
    }
}
