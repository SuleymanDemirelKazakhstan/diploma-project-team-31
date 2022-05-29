package com.project.bookberry.controller;

import com.project.bookberry.entity.Photos;
import com.project.bookberry.service.PhotosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/photos")
public class PhotosController {

    @Autowired
    private PhotosService photosService;

    @GetMapping
    public ResponseEntity<List<Photos>> getAll() {
        return ResponseEntity.ok(photosService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Photos> get(@PathVariable("id") Long id) {
        return ResponseEntity.ok(photosService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Photos> create(@RequestBody Photos entity) {
        return ResponseEntity.ok(photosService.saveOrUpdate(entity));
    }

    @PutMapping
    public ResponseEntity<Photos> update(@RequestBody Photos entity) {
        return ResponseEntity.ok(photosService.saveOrUpdate(entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        photosService.delete(id);
        return ResponseEntity.ok().build();
    }
}
