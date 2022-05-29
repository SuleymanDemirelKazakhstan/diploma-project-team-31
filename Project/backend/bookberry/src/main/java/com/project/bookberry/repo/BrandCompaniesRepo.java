package com.project.bookberry.repo;

import com.project.bookberry.entity.BrandCompanies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandCompaniesRepo extends JpaRepository<BrandCompanies, Long> {
}
