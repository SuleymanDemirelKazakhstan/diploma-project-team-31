package com.project.bookberry.service.impl;

import com.project.bookberry.exception.BookberryException;
import com.project.bookberry.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public class BaseServiceImpl<T, I> implements BaseService<T, I> {

    @Autowired
    protected JpaRepository<T, I> repository;


    @Override
    public T saveOrUpdate(T entity) {
        return repository.save(entity);
    }

    @Override
    public T findById(I id) {
        return repository.findById(id).orElseThrow(() -> new BookberryException("Entity not found by ID: " + id));
    }

    @Override
    public void delete(I id) {
        repository.deleteById(id);
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }
}
