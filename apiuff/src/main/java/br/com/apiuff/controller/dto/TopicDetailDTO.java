package br.com.apiuff.controller.dto;

import br.com.apiuff.entities.Response;
import br.com.apiuff.enums.StatusTopicUFF;

import java.time.LocalDateTime;
import java.util.List;

public class TopicDetailDTO {
    private Long id;
    private String title;
    private String message;
    private LocalDateTime createdAt;
    private String authorName;
    private StatusTopicUFF status;
    private List<ResponseDTO> responses;
}
