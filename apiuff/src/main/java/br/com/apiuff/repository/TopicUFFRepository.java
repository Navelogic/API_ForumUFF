package br.com.apiuff.repository;

import br.com.apiuff.entities.TopicUFF;
import br.com.apiuff.enums.StatusTopicUFF;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicUFFRepository extends JpaRepository<TopicUFF, Long> {
    Page<TopicUFF> findByCourseName(String couseName, Pageable pageable);
    Page<TopicUFF> findByAuthorName(String authorName, Pageable pageable);
    Page<TopicUFF> findByAuthorEmail(String authorEmail, Pageable pageable);
    Page<TopicUFF> findByStatus(StatusTopicUFF status, Pageable pageable);
    Page<TopicUFF> findByTitleContaining(String title, Pageable pageable);
    Page<TopicUFF> findByMessageContaining(String message, Pageable pageable);
}
