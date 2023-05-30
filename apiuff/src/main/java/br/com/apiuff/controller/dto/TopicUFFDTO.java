package br.com.apiuff.controller.dto;

import br.com.apiuff.entities.TopicUFF;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class TopicUFFDTO {

    private Long id;
    private String title;
    private String message;
    private LocalDateTime createdAt;

    // Constructors
    public TopicUFFDTO(TopicUFF topic) {
        this.id = topic.getId();
        this.title = topic.getTitle();
        this.message = topic.getMessage();
        this.createdAt = topic.getCreatedAt();
    }

    public static List<TopicUFFDTO> convert(List<TopicUFF> topic) {
        return topic.stream()
                .map(TopicUFFDTO::new)
                .collect(Collectors.toList());
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}