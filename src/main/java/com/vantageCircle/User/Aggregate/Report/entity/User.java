package com.vantageCircle.User.Aggregate.Report.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="user_steps")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "steps_count")
    private Integer stepsCount;

    @Column(name = "steps_at")
    private LocalDate stepsAt;

    //Getters and Setters
    public long getId() {
        return id;
    }

    public long getUserId() {
        return userId;
    }

    public Integer getStepsCount() {
        return stepsCount;
    }

    public LocalDate getStepsAt() {
        return stepsAt;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setStepsCount(Integer stepsCount) {
        this.stepsCount = stepsCount;
    }

    public void setStepsAt(LocalDate stepsAt) {
        this.stepsAt = stepsAt;
    }
}
