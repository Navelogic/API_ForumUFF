package br.com.apiuff.entities;


import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
public class Response {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;

    @ManyToOne
    private TopicUFF topic;

    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne
    private User author;
    private Boolean solution = false;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public TopicUFF getTopic() {
        return topic;
    }

    public void setTopic(TopicUFF topic) {
        this.topic = topic;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Boolean getSolution() {
        return solution;
    }

    public void setSolution(Boolean solution) {
        this.solution = solution;
    }

    // Constructors
    public Response() {
    }
}
