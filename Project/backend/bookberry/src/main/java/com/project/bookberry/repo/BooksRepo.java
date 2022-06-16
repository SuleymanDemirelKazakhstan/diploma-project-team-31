package com.project.bookberry.repo;

import com.project.bookberry.entity.Books;
import com.project.bookberry.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BooksRepo extends JpaRepository<Books, Long> {
    List<Books> findAllByOrderBySoldCountDesc();
    List<Books> findAllByOrderByDiscountDesc();
    List<Books> findAllByCreatedBetweenOrderBySoldCountDesc(LocalDateTime startDate, LocalDateTime endDate);
    List<Books> findAllByPublisher(Users user);
}
