package ru.aston.druzhinin_ri.task4.repository;

import java.util.List;

public interface Repository <T> {

    List<T> findAll();
    T findEntityById(int id);
    boolean delete(int id);
    boolean create(T t);
    T update(T t);
}
