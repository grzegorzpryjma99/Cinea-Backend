package com.cinea.demo.repositories;

import com.cinea.demo.entity.Film;
import com.cinea.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {

    @Override
    Film getOne(Long aLong);
}
