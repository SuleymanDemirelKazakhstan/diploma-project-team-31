package com.project.bookberry.service.impl;

import com.project.bookberry.entity.Comments;
import com.project.bookberry.repo.CommentsRepo;
import com.project.bookberry.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Service
@Transactional
public class CommentServiceImpl extends BaseServiceImpl<Comments, Long> implements CommentService {
    @Autowired
    private CommentsRepo commentsRepo;

    @PostConstruct
    public void init() {
        repository = commentsRepo;
    }
}
