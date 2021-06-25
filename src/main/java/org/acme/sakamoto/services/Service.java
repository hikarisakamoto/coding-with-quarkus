package org.acme.sakamoto.services;

public interface Service<T> {

    T add(T entity);

    T update(int id, T entity);

    void delete(int id);

}
