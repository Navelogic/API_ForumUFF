package br.com.apiuff.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String categoria;

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    // Construtores
    public Curso() {
    }
    public Curso(Long id, String nome, String categoria) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
    }

    // HashCode e Equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curso curso = (Curso) o;
        return Objects.equals(id, curso.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
