package com.cinea.demo.repositories;

import com.cinea.demo.entity.Screening;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreeningRepository extends CrudRepository<Screening, Long> {
}
