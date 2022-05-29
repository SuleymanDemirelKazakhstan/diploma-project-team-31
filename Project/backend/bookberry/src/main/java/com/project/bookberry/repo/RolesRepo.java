package com.project.bookberry.repo;

import com.project.bookberry.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface RolesRepo extends JpaRepository<Roles, Long> {
    Roles findByRole(String name);
}
