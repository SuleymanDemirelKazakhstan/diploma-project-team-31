package com.project.bookberry.service.impl;

import com.project.bookberry.entity.Books;
import com.project.bookberry.entity.Comments;
import com.project.bookberry.repo.BooksRepo;
import com.project.bookberry.service.BookService;
import com.project.bookberry.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Service
@Transactional
public class BookServiceImpl extends BaseServiceImpl<Books, Long> implements BookService{

    @Autowired
    private BooksRepo repo;

    @Autowired
    private UsersService usersService;

    @PostConstruct
    public void init(){
        repository = repo;
    }

    @Override
    public Books saveOrUpdate(Books entity) {
        if (entity.getPublisher() == null){
            entity.setPublisher(usersService.getCurrentUser());
        }
        return super.saveOrUpdate(entity);
    }

    @Override
    public Books addCommentToBook(Long id, Comments comment) {
        Books book = findById(id);
        if (book.getComments() != null){
            comment.setAuthor(usersService.getCurrentUser());
            book.getComments().add(comment);
        }
        return super.saveOrUpdate(book);
    }
}
