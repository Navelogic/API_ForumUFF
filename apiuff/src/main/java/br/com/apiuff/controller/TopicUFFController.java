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
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/topics")
public class TopicUFFController {

    @Autowired
    private TopicUFFRepository topicUFFRepository;

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping
    public List<TopicUFFDTO> findAll(){
        List<TopicUFF> topics = topicUFFRepository.findAll();
        return TopicUFFDTO.convert(topics);
    }

    @GetMapping(params = "courseName")
    public List<TopicUFFDTO> findByCourseName(@RequestParam("courseName") String courseName) {
        List<TopicUFF> topics = topicUFFRepository.findByCourseName(courseName);
        return TopicUFFDTO.convert(topics);
    }

    @GetMapping(params = "authorName")
    public List<TopicUFFDTO> findByAuthorName(@RequestParam("authorName") String authorName) {
        List<TopicUFF> topics = topicUFFRepository.findByAuthorName(authorName);
        return TopicUFFDTO.convert(topics);
    }

    @GetMapping(params = "authorEmail")
    public List<TopicUFFDTO> findByAuthorEmail(@RequestParam("authorEmail") String authorEmail) {
        List<TopicUFF> topics = topicUFFRepository.findByAuthorEmail(authorEmail);
        return TopicUFFDTO.convert(topics);
    }

    @GetMapping(params = "status")
    public List<TopicUFFDTO> findByStatus(@RequestParam String status) {
        try {
            StatusTopicUFF statusEnum = StatusTopicUFF.valueOf(status);
            List<TopicUFF> topics = topicUFFRepository.findByStatus(statusEnum);
            return TopicUFFDTO.convert(topics);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid status: " + status);
        }
    }
    @GetMapping(params = "title")
    public List<TopicUFFDTO> findByTitle(@RequestParam("title") String title) {
        List<TopicUFF> topics = topicUFFRepository.findByTitleContaining(title);
        return TopicUFFDTO.convert(topics);
    }

    @GetMapping(params = "message")
    public List<TopicUFFDTO> findByMessage(@RequestParam("message") String message) {
        List<TopicUFF> topics = topicUFFRepository.findByMessageContaining(message);
        return TopicUFFDTO.convert(topics);
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
