package com.cinea.demo.dao.repositories;

import com.cinea.demo.dao.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
/*
    User getUserByEmailAndPassword(String email, String password);

    @Query(value = "SELECT u.salt FROM users u WHERE u.email=?1", nativeQuery = true)
    */
    Optional<User> getUserByEmail(String email);
}
