package org.acme.sakamoto.repositories;

import org.acme.sakamoto.models.Book;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class BookRepository implements Repository<Book> {

    private List<Book> books = new ArrayList<>();

    @Override
    public Book add(Book entity) {
        entity.setId(books.size() + 1);
        books.add(entity);
        return entity;
    }

    @Override
    public Book update(int id, Book entity) {
        books.set(id - 1, entity);
        return entity;
    }

    @Override
    public void delete(int id) {
        books.remove(id - 1);
    }

    @Override
    public Book findById(int id) {
        return books.get(id + 1);
    }

    public List<Book> list() {
        return books;
    }

    public Book findByName(String name) {
        return books.stream()
                .filter(book -> book.getName().equals(name))
                .findFirst()
                .orElse(new Book());
    }

    public List<Book> findByAuthor(String author) {
        return books.stream()
                .filter(book -> book.getAuthor().equals(author))
                .collect(Collectors.toList());
    }
}
