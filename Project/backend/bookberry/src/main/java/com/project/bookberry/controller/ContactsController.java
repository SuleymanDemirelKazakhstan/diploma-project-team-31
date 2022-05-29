package com.project.bookberry.controller;

import com.project.bookberry.entity.Contacts;
import com.project.bookberry.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactsController {
    @Autowired
    private ContactService contactService;

    @GetMapping
    public ResponseEntity<List<Contacts>> getAll() {
        return ResponseEntity.ok(contactService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contacts> get(@PathVariable("id") Long id) {
        return ResponseEntity.ok(contactService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Contacts> create(@RequestBody Contacts entity) {
        return ResponseEntity.ok(contactService.saveOrUpdate(entity));
    }

    @PutMapping
    public ResponseEntity<Contacts> update(@RequestBody Contacts entity) {
        return ResponseEntity.ok(contactService.saveOrUpdate(entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        contactService.delete(id);
        return ResponseEntity.ok().build();
    }
}
