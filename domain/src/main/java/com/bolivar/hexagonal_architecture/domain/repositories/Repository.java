package com.bolivar.hexagonal_architecture.domain.repositories;

import java.util.List;

public interface Repository<T,E> {

    List<T> getAll();

    T getById(E id);

    T update(T object);

    T delete(E id);

    T save(T object);
}
