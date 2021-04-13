package com.cinea.demo.dao.repositories;


import com.cinea.demo.dao.entity.Logs;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends CrudRepository<Logs, Long> {
}