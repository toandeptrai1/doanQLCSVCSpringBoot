package com.doan.QLCSVC.repo;

import com.doan.QLCSVC.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
