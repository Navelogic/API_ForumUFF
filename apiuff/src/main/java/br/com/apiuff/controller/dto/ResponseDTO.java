package br.com.apiuff.controller.dto;

import br.com.apiuff.entities.Response;

import java.time.LocalDateTime;

public class ResponseDTO {
    private Long id;
    private String message;
    private LocalDateTime createdAt;
    private String authorName;

    //Getters
    public Long getId() {
        return id;
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

    // Constructors
    public ResponseDTO(Response response) {
        this.id = response.getId();
        this.message = response.getMessage();
        this.createdAt = response.getCreatedAt();
        this.authorName = response.getAuthor().getName();
    }
}

