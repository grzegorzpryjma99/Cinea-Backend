package com.cinea.demo.repositories;

import com.cinea.demo.entity.UserDetails;
import org.springframework.data.repository.CrudRepository;

public interface UserDetailsRepository  extends CrudRepository<UserDetails, Long> {
}
