package com.example.api2cart.demotest.service;

import java.util.List;

public interface AbstractServiceCrud<D> {

    List<D> getAll();

    D get(Long id);

    void add(D entity);

    void delete(D entity);

    void deleteById(Long entityId);

    void update(D entity);
}