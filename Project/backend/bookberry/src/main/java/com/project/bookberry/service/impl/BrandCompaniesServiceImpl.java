package com.project.bookberry.service.impl;

import com.project.bookberry.entity.BrandCompanies;
import com.project.bookberry.repo.BrandCompaniesRepo;
import com.project.bookberry.service.BrandCompaniesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Service
@Transactional
public class BrandCompaniesServiceImpl extends BaseServiceImpl<BrandCompanies, Long> implements BrandCompaniesService {
    @Autowired
    private BrandCompaniesRepo repo;

    @PostConstruct
    public void init() {
        repository = repo;
    }
}
