package com.project.vehiclerental.repository;

import com.project.vehiclerental.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}