package com.cinea.demo.dao.repositories;

import com.cinea.demo.dao.entity.UserDetails;
import org.springframework.data.repository.CrudRepository;

public interface UserDetailsRepository  extends CrudRepository<UserDetails, Long> {
}
