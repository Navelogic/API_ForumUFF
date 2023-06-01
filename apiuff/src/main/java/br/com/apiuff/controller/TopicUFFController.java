package br.com.apiuff.controller;

import br.com.apiuff.controller.dto.TopicDetailDTO;
import br.com.apiuff.controller.dto.TopicUFFDTO;
import br.com.apiuff.controller.form.TopicForm;
import br.com.apiuff.controller.form.UpdateTopicUFFForm;
import br.com.apiuff.entities.TopicUFF;
import br.com.apiuff.enums.StatusTopicUFF;
import br.com.apiuff.repository.CourseRepository;
import br.com.apiuff.repository.TopicUFFRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;


@RestController
@RequestMapping("/topics")
public class TopicUFFController {

    @Autowired
    private TopicUFFRepository topicUFFRepository;

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping
    public Page<TopicUFFDTO> findAll(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<TopicUFF> topicPage = topicUFFRepository.findAll(pageable);
        return topicPage.map(TopicUFFDTO::new);
    }
    @GetMapping(params = "courseName")
    public Page<TopicUFFDTO> findByCourseName(@RequestParam("courseName") String courseName, @RequestParam int page, @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<TopicUFF> topicPage = topicUFFRepository.findByCourseName(courseName, pageable);
         return topicPage.map(TopicUFFDTO::new);
    }

    @GetMapping(params = "authorName")
    public Page<TopicUFFDTO> findByAuthorName(@RequestParam("authorName") String authorName, @RequestParam int page, @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<TopicUFF> topicPage = topicUFFRepository.findByAuthorName(authorName, pageable);
        return topicPage.map(TopicUFFDTO::new);
    }

    @GetMapping(params = "authorEmail")
    public Page<TopicUFFDTO> findByAuthorEmail(@RequestParam("authorEmail") String authorEmail, @RequestParam int page, @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<TopicUFF> topicPage = topicUFFRepository.findByAuthorEmail(authorEmail, pageable);
        return topicPage.map(TopicUFFDTO::new);
    }

    @GetMapping(params = "status")
    public Page<TopicUFFDTO> findByStatus(@RequestParam String status, @RequestParam int page, @RequestParam int size) {
        try {
            StatusTopicUFF statusEnum = StatusTopicUFF.valueOf(status);
            Pageable pageable = PageRequest.of(page, size);
            Page<TopicUFF> topicPage = topicUFFRepository.findByStatus(statusEnum, pageable);
            return topicPage.map(TopicUFFDTO::new);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid status: " + status);
        }
    }
    @GetMapping(params = "title")
    public Page<TopicUFFDTO> findByTitle(@RequestParam("title") String title, @RequestParam int page, @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<TopicUFF> topicPage = topicUFFRepository.findByTitleContaining(title, pageable);
        return topicPage.map(TopicUFFDTO::new);
    }

    @GetMapping(params = "message")
    public Page<TopicUFFDTO> findByMessage(@RequestParam("message") String message, @RequestParam int page, @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<TopicUFF> topicPage = topicUFFRepository.findByMessageContaining(message, pageable);
        return topicPage.map(TopicUFFDTO::new);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicDetailDTO> getTopicById(@PathVariable Long id){
        Optional<TopicUFF> topic = topicUFFRepository.findById(id);
        return topic.map(topicUFF -> ResponseEntity.ok(new TopicDetailDTO(topicUFF))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Transactional
    public ResponseEntity<TopicUFFDTO> addTopic(@RequestBody @Valid TopicForm form, UriComponentsBuilder uriBuilder){
        TopicUFF topic = form.convert(courseRepository);
        topicUFFRepository.save(topic);
        URI uri = uriBuilder.path("/topics/{id}").buildAndExpand(topic.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicUFFDTO(topic));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TopicUFFDTO> updateTopic(@PathVariable Long id, @RequestBody @Valid UpdateTopicUFFForm form){
        Optional<TopicUFF> optional = topicUFFRepository.findById(id);
        if(optional.isPresent()){
            TopicUFF topic = form.update(id, topicUFFRepository);
            return ResponseEntity.ok(new TopicUFFDTO(topic));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deleteTopic(@PathVariable Long id){
        Optional<TopicUFF> optional = topicUFFRepository.findById(id);
        if(optional.isPresent()){
            topicUFFRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping
    @Transactional
    @RequestMapping("/deleteAll")
    public ResponseEntity<?> deleteAllTopics(){
        topicUFFRepository.deleteAll();
        return ResponseEntity.ok().build();
    }
}
