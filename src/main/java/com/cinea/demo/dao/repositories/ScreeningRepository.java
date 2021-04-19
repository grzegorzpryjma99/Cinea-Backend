package com.cinea.demo.dao.repositories;

import com.cinea.demo.dao.entity.Screening;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreeningRepository extends CrudRepository<Screening, Long> {
}
