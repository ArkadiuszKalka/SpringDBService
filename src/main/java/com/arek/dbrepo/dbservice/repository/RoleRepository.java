package com.arek.dbrepo.dbservice.repository;

import com.arek.dbrepo.dbservice.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByRole(String role);
}
