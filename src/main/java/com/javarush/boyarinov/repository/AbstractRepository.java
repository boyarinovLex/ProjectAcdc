package com.javarush.boyarinov.repository;

import com.javarush.boyarinov.model.Model;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class AbstractRepository<T extends Model> implements Repository<T> {

    private final Map<Long, T> modelMap = new ConcurrentHashMap<>();

    private final AtomicLong id = new AtomicLong(1L);

    @Override
    public void create(T model) {
        model.setId(id.getAndIncrement());
        update(model);
    }

    @Override
    public Collection<T> getAll() {
        return modelMap.values();
    }

    @Override
    public T get(long id) {
        return modelMap.get(id);
    }

    @Override
    public void update(T model) {
        modelMap.put(model.getId(), model);
    }

    @Override
    public void delete(T model) {
        modelMap.remove(model.getId());
    }
}
