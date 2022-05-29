package com.project.bookberry.service;

import java.util.List;

public interface BaseService <T, I>{
    T saveOrUpdate(T entity);

    T findById(I id);

    void delete(I id);

    List<T> findAll();
}
