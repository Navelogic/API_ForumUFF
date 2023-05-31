package br.com.apiuff.controller.form;

import br.com.apiuff.entities.TopicUFF;
import br.com.apiuff.repository.TopicUFFRepository;
import jakarta.validation.constraints.NotNull;

public class UpdateTopicUFFForm {
    @NotNull(message = "Title cannot be null")
    private String title;
    @NotNull(message = "Message cannot be null")
    private String message;

    // Getters and Setters
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

    public TopicUFF updade(Long id, TopicUFFRepository topicUFFRepository) {
        TopicUFF topic = topicUFFRepository.getReferenceById(id);
        topic.setTitle(this.title);
        topic.setMessage(this.message);
        return topic;
    }
}
