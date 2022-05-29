package com.project.bookberry.repo;

import com.project.bookberry.entity.Quotes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuotesRepo extends JpaRepository<Quotes, Long> {
}
