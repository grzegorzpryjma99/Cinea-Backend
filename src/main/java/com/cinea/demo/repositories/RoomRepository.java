package com.cinea.demo.repositories;

import com.cinea.demo.entity.Film;
import com.cinea.demo.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    @Override
    Room getOne(Long aLong);
}
