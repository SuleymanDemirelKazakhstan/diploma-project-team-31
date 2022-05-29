package com.project.bookberry.service;

import com.project.bookberry.entity.Books;
import com.project.bookberry.entity.Comments;

public interface BookService extends BaseService<Books, Long>{
    Books addCommentToBook(Long id, Comments comment);
}
