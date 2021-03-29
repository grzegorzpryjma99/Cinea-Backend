package com.cinea.demo.dao;

import com.cinea.demo.dao.entity.Film;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepo extends CrudRepository<Film, Long> {
}
