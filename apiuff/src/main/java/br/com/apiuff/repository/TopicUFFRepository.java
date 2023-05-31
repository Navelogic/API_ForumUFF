package br.com.apiuff.repository;

import br.com.apiuff.entities.TopicUFF;
import br.com.apiuff.enums.StatusTopicUFF;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicUFFRepository extends JpaRepository<TopicUFF, Long> {
    List<TopicUFF> findByCourseName(String couseName);

    List<TopicUFF> findByAuthorName(String authorName);

    List<TopicUFF> findByAuthorEmail(String authorEmail);

    List<TopicUFF> findByStatus(StatusTopicUFF status);

    List<TopicUFF> findByTitleContaining(String title);

    List<TopicUFF> findByMessageContaining(String message);
}
