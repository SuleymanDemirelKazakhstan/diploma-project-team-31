package com.project.bookberry.controller;

import com.project.bookberry.entity.BrandCompanies;
import com.project.bookberry.service.BrandCompaniesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand-company")
public class BrandCompaniesController {

    @Autowired
    private BrandCompaniesService brandCompaniesService;

    @GetMapping
    public ResponseEntity<List<BrandCompanies>> getAll() {
        return ResponseEntity.ok(brandCompaniesService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BrandCompanies> get(@PathVariable("id") Long id) {
        return ResponseEntity.ok(brandCompaniesService.findById(id));
    }

    @PostMapping
    public ResponseEntity<BrandCompanies> create(@RequestBody BrandCompanies entity) {
        return ResponseEntity.ok(brandCompaniesService.saveOrUpdate(entity));
    }

    @PutMapping
    public ResponseEntity<BrandCompanies> update(@RequestBody BrandCompanies entity) {
        return ResponseEntity.ok(brandCompaniesService.saveOrUpdate(entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        brandCompaniesService.delete(id);
        return ResponseEntity.ok().build();
    }
}
