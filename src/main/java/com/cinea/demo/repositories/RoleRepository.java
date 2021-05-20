package com.cinea.demo.repositories;

import java.util.Optional;

import com.cinea.demo.entity.Role;
import com.cinea.demo.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(Roles name);
}