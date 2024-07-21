package com.bolivar.hexagonal_architecture.outputs.rest.controllers;

import com.bolivar.hexagonal_architecture.domain.services.AppUseCase;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class RestControllerAbstract<T, E> implements RestControllerInterface<T, E> {

    private final AppUseCase<T, E> useCase;

    public RestControllerAbstract(AppUseCase<T, E> useCase) {
        this.useCase = useCase;
    }

    @GetMapping
    @Override
    public List<T> getAll() {
        return useCase.getAll();
    }

    @GetMapping("/{id}")
    @Override
    public T getById(@PathVariable E id) {
        return useCase.getById(id);
    }

    @PostMapping
    @Override
    public T save(@RequestBody T object) {
        return useCase.save(object);
    }

    @PutMapping("/{id}")
    @Override
    public T update(@PathVariable E id, @RequestBody T object) {
        return useCase.update(id, object);
    }

    @DeleteMapping("/{id}")
    @Override
    public T delete(@PathVariable E id) {
        return useCase.delete(id);
    }
}
