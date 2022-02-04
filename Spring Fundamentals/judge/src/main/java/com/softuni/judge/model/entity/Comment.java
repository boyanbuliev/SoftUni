package com.softuni.judge.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comments")
public class Comment extends BaseEntity {
    private Integer score;
    private String textContent;
    private User author;
    private Homework homework;

    public Comment() {
    }

    @Column(name = "score")
    public Integer getScore() {
        return score;
    }

    public Comment setScore(Integer score) {
        this.score = score;
        return this;
    }

    @Column(name = "text_content", columnDefinition = "TEXT")
    public String getTextContent() {
        return textContent;
    }

    public Comment setTextContent(String textContent) {
        this.textContent = textContent;
        return this;
    }

    @ManyToOne
    public User getAuthor() {
        return author;
    }

    public Comment setAuthor(User author) {
        this.author = author;
        return this;
    }

    @ManyToOne
    public Homework getHomework() {
        return homework;
    }

    public Comment setHomework(Homework homework) {
        this.homework = homework;
        return this;
    }
}
