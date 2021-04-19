package com.cinea.demo.dao.repositories;

import com.cinea.demo.dao.entity.Categories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepository extends CrudRepository<Categories, Long> {
}
