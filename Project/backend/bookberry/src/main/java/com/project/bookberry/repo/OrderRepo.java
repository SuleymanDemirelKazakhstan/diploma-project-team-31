package com.project.bookberry.repo;

import com.project.bookberry.entity.Orders;
import com.project.bookberry.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Orders, Long> {
    List<Orders> findAllByBook_Publisher(Users users);
}
