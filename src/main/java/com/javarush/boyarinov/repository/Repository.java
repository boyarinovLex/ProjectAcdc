package com.javarush.boyarinov.repository;

import java.util.Collection;

public interface Repository<T> {

    void create(T model);

    Collection<T> getAll();

    T get(long id);

    void update(T model);

    void delete(T model);

}
