package com.project.bookberry.service.impl;

import com.project.bookberry.entity.Contacts;
import com.project.bookberry.repo.ContactsRepo;
import com.project.bookberry.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Service
@Transactional
public class ContactServiceImpl extends BaseServiceImpl<Contacts, Long> implements ContactService {
    @Autowired
    private ContactsRepo repo;

    @PostConstruct
    public void init() {
        repository = repo;
    }
}
