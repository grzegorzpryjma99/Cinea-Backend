package com.cinea.demo.dao.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name ="logs")
public class Logs {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "session_id")
    private String sessionId;

    @Column(name = "log_time")
    private Timestamp logTime;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @PrePersist
    public void setLogTime() {
        logTime = new Timestamp(System.currentTimeMillis());
    }

    public Logs(String sessionId, User user) {
        this.sessionId = sessionId;
        this.user = user;
    }

    public Logs() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Timestamp getLogTime() {
        return logTime;
    }

    public void setLogTime(Timestamp logTime) {
        this.logTime = logTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

