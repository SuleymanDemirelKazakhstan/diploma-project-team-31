package com.project.bookberry.service;

import com.project.bookberry.dto.CheckoutsDTO;
import com.project.bookberry.entity.Checkouts;
import com.project.bookberry.entity.Orders;

import java.util.List;

public interface CheckoutService extends BaseService<Checkouts, Long>{
    List<Orders> save(CheckoutsDTO checkouts);

    List<Orders> findByUser();
}
