package com.project.bookberry.service.impl;

import com.project.bookberry.entity.Quotes;
import com.project.bookberry.repo.QuotesRepo;
import com.project.bookberry.service.QuotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Service
@Transactional
public class QuotesServiceImpl extends BaseServiceImpl<Quotes, Long> implements QuotesService {
    @Autowired
    private QuotesRepo repo;

    @PostConstruct
    public void init() {
        repository = repo;
    }
}
