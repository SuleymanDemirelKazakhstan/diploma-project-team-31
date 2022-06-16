package com.project.bookberry.controller;

import com.project.bookberry.dto.CheckoutsDTO;
import com.project.bookberry.entity.Checkouts;
import com.project.bookberry.entity.Orders;
import com.project.bookberry.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/checkout")
public class CheckoutController {
    @Autowired
    private CheckoutService checkoutService;

    @GetMapping("/{id}")
    public ResponseEntity<Checkouts> get(@PathVariable("id") Long id){
        return ResponseEntity.ok(checkoutService.findById(id));
    }

    @GetMapping("/findByUser")
    public ResponseEntity<List<Orders>> getCheckoutsByUser(){
        return ResponseEntity.ok(checkoutService.findByUser());
    }

    @GetMapping
    public ResponseEntity<List<Checkouts>> getAll(){
        return ResponseEntity.ok(checkoutService.findAll());
    }

    @PostMapping
    public ResponseEntity<List<Orders>> create(@RequestBody CheckoutsDTO checkout){
        return ResponseEntity.ok(checkoutService.save(checkout));
    }

    @PutMapping
    public ResponseEntity<Checkouts> update(@RequestBody Checkouts checkout){
        return ResponseEntity.ok(checkoutService.saveOrUpdate(checkout));
    }

    @DeleteMapping
    public ResponseEntity delete(@PathVariable("id") Long id){
        checkoutService.delete(id);
        return ResponseEntity.ok().build();
    }
}
