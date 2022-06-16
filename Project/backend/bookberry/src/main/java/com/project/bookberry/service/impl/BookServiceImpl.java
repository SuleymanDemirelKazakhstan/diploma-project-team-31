package com.project.bookberry.service.impl;

import com.project.bookberry.dto.enums.BookType;
import com.project.bookberry.entity.Books;
import com.project.bookberry.entity.Comments;
import com.project.bookberry.entity.Users;
import com.project.bookberry.repo.BooksRepo;
import com.project.bookberry.service.BookService;
import com.project.bookberry.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BookServiceImpl extends BaseServiceImpl<Books, Long> implements BookService {

    @Autowired
    private BooksRepo booksRepo;

    @Autowired
    private UsersService usersService;

    @PostConstruct
    public void init() {
        repository = booksRepo;
    }

    @Override
    public Books saveOrUpdate(Books entity) {
        if (entity.getPublisher() == null) {
            entity.setPublisher(usersService.getCurrentUser());
        }
        return super.saveOrUpdate(entity);
    }

    @Override
    public Books addCommentToBook(Long id, Comments comment) {
        Books book = findById(id);
        if (book.getComments() == null) {
            book.setComments(new ArrayList<>());
        }
        comment.setAuthor(usersService.getCurrentUser());
        book.getComments().add(comment);
        return super.saveOrUpdate(book);
    }

    @Override
    public List<Books> findByType(BookType type) {
        List<Books> books = null;
        if (type.equals(BookType.POPULAR)) {
            books = booksRepo.findAllByOrderBySoldCountDesc();
        } else if (type.equals(BookType.DISCOUNT)) {
            books = booksRepo.findAllByOrderByDiscountDesc();
        } else if (type.equals(BookType.NEWS)) {

        } else if (type.equals(BookType.BESTSELLER)) {
            books = booksRepo.findAllByCreatedBetweenOrderBySoldCountDesc(LocalDateTime.now(), LocalDateTime.now());
        }
        return books;
    }

    @Override
    public List<Books> findByCurrentUser() {
        Users user = usersService.getCurrentUser();
        return booksRepo.findAllByPublisher(user);
    }

    @Override
    public Books setDiscount(Long id, Integer discount) {
        Books book = booksRepo.findById(id).orElse(null);
        book.setDiscount(discount);
        return booksRepo.save(book);
    }
}
