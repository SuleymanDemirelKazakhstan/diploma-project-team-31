package com.project.bookberry.service.impl;

import com.project.bookberry.entity.Photos;
import com.project.bookberry.repo.PhotosRepo;
import com.project.bookberry.service.PhotosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Service
@Transactional
public class PhotosServiceImpl extends BaseServiceImpl<Photos, Long> implements PhotosService {
    @Autowired
    private PhotosRepo repo;

    @PostConstruct
    public void init() {
        repository = repo;
    }
}
