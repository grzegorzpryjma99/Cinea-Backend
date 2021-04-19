package com.cinea.demo.dao.repositories;

import com.cinea.demo.dao.entity.FilmDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmDetailsRepository extends CrudRepository<FilmDetails, Long> {
}
