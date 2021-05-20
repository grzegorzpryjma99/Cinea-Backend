package com.cinea.demo.services;

import com.cinea.demo.entity.User;
import com.cinea.demo.repositories.LogRepository;
import com.cinea.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private  final UserRepository userRepository;
    private final LogRepository logRepository;

    @Autowired
    public UserService(UserRepository userRepository, LogRepository logRepository) {
        this.userRepository = userRepository;
        this.logRepository = logRepository;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public LogRepository getLogRepository() {
        return logRepository;
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
        //UserDetails details = new UserDetails("Grzegorz","Pryjma", Date.valueOf("1999-03-03"), 785012132L);
        //User u = new User("admin@admin.pl","admin",details);

        //save(u);
       // Logs l = new Logs("1",u);
       // UserDetails ud = new UserDetails("ds","das",d,999L);
    }
}
