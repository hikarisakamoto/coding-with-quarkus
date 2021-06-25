package org.acme.sakamoto.repositories;

public interface Repository <T>{

    T add (T entity);
    T update (int id, T entity);
    void delete(int id);
    T findById(int id);
}
