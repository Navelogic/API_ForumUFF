package br.com.apiuff.entities;

import br.com.apiuff.enums.StatusTopicUFF;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TopicUFF {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String message;
    private LocalDateTime createdAt = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private StatusTopicUFF status = StatusTopicUFF.NOT_ANSWERED;

    @ManyToOne
    private User author;

    @ManyToOne
    private Course course;

    @OneToMany(mappedBy = "topic")
    private List<Response> responses = new ArrayList<>();

    // Constructors
    public TopicUFF() {
    }
    public TopicUFF(String title, String message, Course course) {
        this.title = title;
        this.message = message;
        this.course = course;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public StatusTopicUFF getStatus() {
        return status;
    }

    public void setStatus(StatusTopicUFF status) {
        this.status = status;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Response> getResponses() {
        return responses;
    }

    public void setResponses(List<Response> responses) {
        this.responses = responses;
    }

}
