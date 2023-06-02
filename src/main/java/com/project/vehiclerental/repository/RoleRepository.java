package com.project.vehiclerental.repository;

import com.project.vehiclerental.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}