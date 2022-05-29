package com.project.bookberry.controller;

import com.project.bookberry.entity.Categories;
import com.project.bookberry.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoriesController {
    @Autowired
    private CategoriesService categoriesService;

    @GetMapping
    public ResponseEntity<List<Categories>> getAll() {
        return ResponseEntity.ok(categoriesService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categories> get(@PathVariable("id") Long id) {
        return ResponseEntity.ok(categoriesService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Categories> create(@RequestBody Categories entity) {
        return ResponseEntity.ok(categoriesService.saveOrUpdate(entity));
    }

    @PutMapping
    public ResponseEntity<Categories> update(@RequestBody Categories entity) {
        return ResponseEntity.ok(categoriesService.saveOrUpdate(entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        categoriesService.delete(id);
        return ResponseEntity.ok().build();
    }
}
