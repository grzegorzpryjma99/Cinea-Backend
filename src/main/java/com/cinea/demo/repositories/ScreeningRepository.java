package com.cinea.demo.repositories;

import com.cinea.demo.entity.Film;
import com.cinea.demo.entity.Screening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ScreeningRepository extends JpaRepository<Screening, Long> {

    @Override
    Screening getOne(Long aLong);
}
