package com.cinea.demo.repositories;

import com.cinea.demo.entity.FilmDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmDetailsRepository extends CrudRepository<FilmDetails, Long> {
}
