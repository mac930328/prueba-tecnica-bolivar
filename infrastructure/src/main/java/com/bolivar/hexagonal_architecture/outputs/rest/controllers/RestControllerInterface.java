package com.bolivar.hexagonal_architecture.outputs.rest.controllers;

import java.util.List;

public interface RestControllerInterface<T, E> {


    List<T> getAll();

    T getById(E id);


    T save(T object);


    T update(E id, T object);


    T delete(E id);


}
