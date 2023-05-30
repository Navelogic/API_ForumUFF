package br.com.apiuff.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String category;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    // Constructors
    public Course() {
    }
    public Course(Long id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }
}
