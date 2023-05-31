package br.com.apiuff.controller.form;

import br.com.apiuff.entities.Course;
import br.com.apiuff.entities.TopicUFF;
import br.com.apiuff.repository.CourseRepository;

public class TopicForm {
    private String title;
    private String message;
    private String courseName;

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

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public TopicUFF convert(CourseRepository courseRepository) {
        Course course = courseRepository.findByName(courseName);
        return new TopicUFF(title, message, course);
    }
}
