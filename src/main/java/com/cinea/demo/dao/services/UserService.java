package com.cinea.demo.dao.services;
import com.cinea.demo.dao.entity.Logs;
import com.cinea.demo.dao.entity.User;
import com.cinea.demo.dao.entity.UserDetails;
import com.cinea.demo.dao.repositories.FilmRepo;
import com.cinea.demo.dao.entity.Film;
import com.cinea.demo.dao.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB(){
       //Date d = new Date(1999-01-01);
       // User u = new User("user@gmail.com","user1");
       // save(u);
       // Logs l = new Logs("1",u);
       // UserDetails ud = new UserDetails("ds","das",d,999L);
    }
}
