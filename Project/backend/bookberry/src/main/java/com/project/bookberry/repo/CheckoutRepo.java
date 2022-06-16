package com.project.bookberry.repo;

import com.project.bookberry.entity.Checkouts;
import com.project.bookberry.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheckoutRepo extends JpaRepository<Checkouts, Long> {
//    List<Checkouts> findAllByBook_Publisher(Users users);
}
