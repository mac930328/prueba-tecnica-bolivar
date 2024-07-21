package com.bolivar.hexagonal_architecture.domain.services;

import java.util.List;

public interface AppUseCase<T, E> {

    List<T> getAll();

    T getById(E id);

    T save(T object);

    T update(E id, T object);

    T delete(E id);
}
