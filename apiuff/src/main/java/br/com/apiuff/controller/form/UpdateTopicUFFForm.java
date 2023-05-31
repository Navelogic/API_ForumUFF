package br.com.apiuff.controller.form;

import br.com.apiuff.entities.TopicUFF;
import br.com.apiuff.repository.TopicUFFRepository;
import jakarta.validation.constraints.NotEmpty;

public class UpdateTopicUFFForm {
    @NotEmpty(message = "Title cannot be empty")
    private String title;
    @NotEmpty(message = "Message cannot be empty")
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

    public TopicUFF update(Long id, TopicUFFRepository topicUFFRepository) {
        TopicUFF topic = topicUFFRepository.getReferenceById(id);
        topic.setTitle(this.title);
        topic.setMessage(this.message);
        return topic;
    }
}
