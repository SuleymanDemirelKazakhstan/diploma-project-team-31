package com.project.bookberry.service.impl;

import com.project.bookberry.dto.CheckoutsDTO;
import com.project.bookberry.dto.SimpleBooksDTO;
import com.project.bookberry.entity.Books;
import com.project.bookberry.entity.Checkouts;
import com.project.bookberry.entity.Orders;
import com.project.bookberry.entity.Users;
import com.project.bookberry.repo.BooksRepo;
import com.project.bookberry.repo.CheckoutRepo;
import com.project.bookberry.repo.OrderRepo;
import com.project.bookberry.service.BookService;
import com.project.bookberry.service.CheckoutService;
import com.project.bookberry.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class CheckoutServiceImpl extends BaseServiceImpl<Checkouts, Long> implements CheckoutService {

    @Autowired
    private CheckoutRepo checkoutRepo;

    @Autowired
    private BooksRepo booksRepo;

    @Autowired
    private UsersService usersService;

    @Autowired
    private BookService bookService;

    @Autowired
    private OrderRepo orderRepo;

    @PostConstruct
    public void init(){
        repository = checkoutRepo;
    }

    @Override
    public List<Orders> save(CheckoutsDTO checkouts) {
        Checkouts checkout = getFromDTO(checkouts);

        String fullname = checkout.getFirstName() != null ? checkout.getFirstName() : ""
                + " " + checkout.getLastName() != null ? checkout.getLastName() : "";
        checkout.setFullname(fullname);
        Checkouts saved = checkoutRepo.save(checkout);
        List<Orders> orders = new ArrayList<>();
        checkouts.getBooks().forEach(it -> {
            Orders order = new Orders();
            Optional<Books> booksOptional = booksRepo.findById(it.getId());
            if (booksOptional.isPresent()){
                Books books = booksOptional.get();
                books.setSoldCount(books.getSoldCount() + 1);
                order.setBook(books);
                order.setAmount(it.getAmount());
                order.setCheckout(saved);
                orders.add(order);
            }
        });
        return orderRepo.saveAll(orders);
    }

    @Override
    public List<Orders> findByUser() {
        Users user = usersService.getCurrentUser();
        List<Orders> orders = orderRepo.findAllByBook_Publisher(user);
        return orders;
    }

    private Checkouts getFromDTO(CheckoutsDTO checkoutsDTO){
        Checkouts checkout = new Checkouts();
        checkout.setId(checkoutsDTO.getId());
        checkout.setAddress(checkoutsDTO.getAddress());
        checkout.setCity(checkoutsDTO.getCity());
        checkout.setCountry(checkoutsDTO.getCountry());
        checkout.setEmail(checkoutsDTO.getEmail());
        checkout.setLastName(checkoutsDTO.getLastName());
        checkout.setFirstName(checkoutsDTO.getFirstName());
        checkout.setMessage(checkoutsDTO.getMessage());
        checkout.setPhoneNumber(checkoutsDTO.getPhoneNumber());
        return checkout;
    }
}
