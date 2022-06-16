package com.project.bookberry.controller;

import com.project.bookberry.dto.enums.BookType;
import com.project.bookberry.entity.Books;
import com.project.bookberry.entity.Comments;
import com.project.bookberry.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<Books>> getAll() {
        return ResponseEntity.ok(bookService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Books> get(@PathVariable("id") Long id) {
        return ResponseEntity.ok(bookService.findById(id));
    }

    @GetMapping("/findByType/{type}")
    public ResponseEntity<List<Books>> findByType(@PathVariable("type") BookType type) {
        return ResponseEntity.ok(bookService.findByType(type));
    }

    @PostMapping("/{id}/setDiscount/{discount}")
    public ResponseEntity<Books> setDiscount(@PathVariable("id") Long id,
                                             @PathVariable("discount") Integer discount) {
        return ResponseEntity.ok(bookService.setDiscount(id, discount));
    }

    @GetMapping("/findByUser")
    public ResponseEntity<List<Books>> findByUser() {
        return ResponseEntity.ok(bookService.findByCurrentUser());
    }

    @PostMapping
    public ResponseEntity<Books> create(@RequestBody Books books) {
        return ResponseEntity.ok(bookService.saveOrUpdate(books));
    }

    @PostMapping("/{id}/add-comment")
    public ResponseEntity<Books> addCommentToPost(@PathVariable("id") Long bookId,
                                                  @RequestBody Comments comment) {
        return ResponseEntity.ok(bookService.addCommentToBook(bookId, comment));
    }

    @PutMapping
    public ResponseEntity<Books> update(@RequestBody Books books) {
        return ResponseEntity.ok(bookService.saveOrUpdate(books));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        bookService.delete(id);
        return ResponseEntity.ok().build();
    }
}
