package com.cogent.info.dao;

import java.util.List;

public interface Crud<E, Id> {

    void save(E entity);

    List<E> findAll();

    List<E> findById(Id id);

    void update(E entity);

    void deleteById(Id id);
}
