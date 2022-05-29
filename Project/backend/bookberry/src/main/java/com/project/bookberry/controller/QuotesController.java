package com.project.bookberry.controller;

import com.project.bookberry.entity.Quotes;
import com.project.bookberry.service.QuotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quotes")
public class QuotesController {

    @Autowired
    private QuotesService quotesService;

    @GetMapping
    public ResponseEntity<List<Quotes>> getAll() {
        return ResponseEntity.ok(quotesService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quotes> get(@PathVariable("id") Long id) {
        return ResponseEntity.ok(quotesService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Quotes> create(@RequestBody Quotes entity) {
        return ResponseEntity.ok(quotesService.saveOrUpdate(entity));
    }

    @PutMapping
    public ResponseEntity<Quotes> update(@RequestBody Quotes entity) {
        return ResponseEntity.ok(quotesService.saveOrUpdate(entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        quotesService.delete(id);
        return ResponseEntity.ok().build();
    }
}
