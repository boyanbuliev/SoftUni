package com.softuni.judge.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "homework")
public class Homework extends BaseEntity {
    private LocalDateTime addedOn;
    private String gitAddress;
    private User author;
    private Exercise exercise;

    public Homework() {
    }

    @Column(name = "added_on")
    public LocalDateTime getAddedOn() {
        return addedOn;
    }

    public Homework setAddedOn(LocalDateTime addedOn) {
        this.addedOn = addedOn;
        return this;
    }

    @Column(name = "git_address")
    public String getGitAddress() {
        return gitAddress;
    }

    public Homework setGitAddress(String gitAddress) {
        this.gitAddress = gitAddress;
        return this;
    }

    @ManyToOne
    public User getAuthor() {
        return author;
    }

    public Homework setAuthor(User author) {
        this.author = author;
        return this;
    }

    @ManyToOne
    public Exercise getExercise() {
        return exercise;
    }

    public Homework setExercise(Exercise exercise) {
        this.exercise = exercise;
        return this;
    }
}
