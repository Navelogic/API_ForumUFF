package br.com.apiuff.repository;

import br.com.apiuff.entities.TopicUFF;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicUFFRepository extends JpaRepository<TopicUFF, Long> {
    List<TopicUFF> findByCourseName(String couseName);
}
