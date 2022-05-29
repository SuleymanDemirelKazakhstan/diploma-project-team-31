package com.project.bookberry.service.impl;

import com.project.bookberry.entity.Categories;
import com.project.bookberry.repo.CategoriesRepo;
import com.project.bookberry.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Service
@Transactional
public class CategoriesServiceImpl extends BaseServiceImpl<Categories, Long> implements CategoriesService {
    @Autowired
    private CategoriesRepo repo;

    @PostConstruct
    public void init(){
        repository = repo;
    }
}
