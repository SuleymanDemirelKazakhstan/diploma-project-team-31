package com.project.bookberry.service;

import com.project.bookberry.dto.enums.BookType;
import com.project.bookberry.entity.Books;
import com.project.bookberry.entity.Comments;

import java.util.List;

public interface BookService extends BaseService<Books, Long> {
    Books addCommentToBook(Long id, Comments comment);

    List<Books> findByType(BookType type);

    List<Books> findByCurrentUser();

    Books setDiscount(Long id, Integer discount);
}
