package org.acme.sakamoto.services;

import org.acme.sakamoto.models.Book;
import org.acme.sakamoto.repositories.BookRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class BookService implements Service<Book> {

    @Inject
    BookRepository repository;

    @Override
    public Book add(Book entity) {
        return repository.add(entity);
    }

    @Override
    public Book update(int id, Book entity) {
        return repository.update(id, entity);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }
}
