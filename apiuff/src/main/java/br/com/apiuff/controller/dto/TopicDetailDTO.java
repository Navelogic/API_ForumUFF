package br.com.apiuff.controller.dto;

import br.com.apiuff.entities.TopicUFF;
import br.com.apiuff.enums.StatusTopicUFF;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TopicDetailDTO {
    private Long id;
    private String title;
    private String message;
    private LocalDateTime createdAt;
    private String authorName;
    private StatusTopicUFF status;
    private List<ResponseDTO> responses;

    //Getters
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

    public String getAuthorName() {
        return authorName;
    }

    public StatusTopicUFF getStatus() {
        return status;
    }

    public List<ResponseDTO> getResponses() {
        return responses;
    }

    // Constructors
    public TopicDetailDTO(TopicUFF topic) {
        this.id = topic.getId();
        this.title = topic.getTitle();
        this.message = topic.getMessage();
        this.createdAt = topic.getCreatedAt();
        this.authorName = topic.getAuthor().getName();
        this.status = topic.getStatus();
        this.responses = new ArrayList<>();
        this.responses.addAll(topic.getResponses().stream().map(ResponseDTO::new).toList());
    }
}
