package com.softuni.judge.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "exercises")
public class Exercise extends BaseEntity {
    private String name;
    private LocalDateTime startedOn;
    private LocalDateTime dueDate;

    public Exercise() {
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public Exercise setName(String name) {
        this.name = name;
        return this;
    }

    @Column(name = "started_on")
    public LocalDateTime getStartedOn() {
        return startedOn;
    }

    public Exercise setStartedOn(LocalDateTime startedOn) {
        this.startedOn = startedOn;
        return this;
    }

    @Column(name = "due_date")
    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public Exercise setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
        return this;
    }
}
