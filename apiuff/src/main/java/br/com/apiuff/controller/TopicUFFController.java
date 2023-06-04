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
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/topics")
public class TopicUFFController {
    @Autowired
    private TopicUFFRepository topicUFFRepository;
    @Autowired
    private CourseRepository courseRepository;

    // GETS
    @GetMapping
    @Cacheable(value = "topicList")
    public Page<TopicUFFDTO> findAll(@RequestParam int page, @RequestParam int size, @RequestParam(required = false) String sort) {
        Pageable pageable;

        if (sort != null && !sort.isEmpty()) {
            String[] sortProperties = sort.split(",");
            Sort.Order[] orders = Arrays.stream(sortProperties)
                    .map(this::parseSortProperty)
                    .toArray(Sort.Order[]::new);
            pageable = PageRequest.of(page, size, Sort.by(orders));
        } else {
            pageable = PageRequest.of(page, size);
        }

        Page<TopicUFF> topicPage = topicUFFRepository.findAll(pageable);
        return topicPage.map(TopicUFFDTO::new);
    }

    // /topics?page=0&size=10&sort=title -> sort=title,asc
    // /topics?page=0&size=10&sort=-createdAt -> sort=createdAt,desc
    // /topics?page=0&size=10&sort=title,createdAt -> sort=title,asc&sort=createdAt,asc

    @GetMapping(params = "courseName")
    public Page<TopicUFFDTO> findByCourseName(@RequestParam("courseName") String courseName, @RequestParam int page, @RequestParam int size, @RequestParam(required = false) String sort) {
        Pageable pageable;

        if (sort != null && !sort.isEmpty()) {
            String[] sortProperties = sort.split(",");
            Sort.Order[] orders = Arrays.stream(sortProperties)
                    .map(this::parseSortProperty)
                    .toArray(Sort.Order[]::new);
            pageable = PageRequest.of(page, size, Sort.by(orders));
        } else {
            pageable = PageRequest.of(page, size);
        }

        Page<TopicUFF> topicPage = topicUFFRepository.findByCourseName(courseName, pageable);
        return topicPage.map(TopicUFFDTO::new);
    }

    // /topics?courseName=Digital+Marketing&page=0&size=10&sort=title -> sort=title,asc
    // /topics?courseName=Digital+Marketing&page=0&size=10&sort=-createdAt -> sort=createdAt,desc
    // /topics?courseName=Digital+Marketing&page=0&size=10&sort=title,createdAt -> sort=title,asc&sort=createdAt,asc

    @GetMapping(params = "authorName")
    public Page<TopicUFFDTO> findByAuthorName(@RequestParam("authorName") String authorName, @RequestParam int page, @RequestParam int size, @RequestParam(required = false) String sort) {
        Pageable pageable;

        if (sort != null && !sort.isEmpty()) {
            String[] sortProperties = sort.split(",");
            Sort.Order[] orders = Arrays.stream(sortProperties)
                    .map(this::parseSortProperty)
                    .toArray(Sort.Order[]::new);
            pageable = PageRequest.of(page, size, Sort.by(orders));
        } else {
            pageable = PageRequest.of(page, size);
        }

        Page<TopicUFF> topicPage = topicUFFRepository.findByAuthorName(authorName, pageable);
        return topicPage.map(TopicUFFDTO::new);
    }

    // /topics?authorName=John+Doe&page=0&size=10&sort=title -> sort=title,asc
    // /topics?authorName=John+Doe&page=0&size=10&sort=-createdAt -> sort=createdAt,desc
    // /topics?authorName=John+Doe&page=0&size=10&sort=title,createdAt -> sort=title,asc&sort=createdAt,asc

    @GetMapping(params = "authorEmail")
    public Page<TopicUFFDTO> findByAuthorEmail(@RequestParam("authorEmail") String authorEmail, @RequestParam int page, @RequestParam int size, @RequestParam(required = false) String sort) {
        Pageable pageable;

        if (sort != null && !sort.isEmpty()) {
            String[] sortProperties = sort.split(",");
            Sort.Order[] orders = Arrays.stream(sortProperties)
                    .map(this::parseSortProperty)
                    .toArray(Sort.Order[]::new);
            pageable = PageRequest.of(page, size, Sort.by(orders));
        } else {
            pageable = PageRequest.of(page, size);
        }

        Page<TopicUFF> topicPage = topicUFFRepository.findByAuthorEmail(authorEmail, pageable);
        return topicPage.map(TopicUFFDTO::new);
    }

    // /topics?authorEmail=john.doe@localhost&page=0&size=10&sort=title -> sort=title,asc
    // /topics?authorEmail=john.doe@localhost&page=0&size=10&sort=-createdAt -> sort=createdAt,desc
    // /topics?authorEmail=john.doe@localhost&page=0&size=10&sort=title,createdAt -> sort=title,asc&sort=createdAt,asc

    @GetMapping(params = "status")
    public Page<TopicUFFDTO> findByStatus(@RequestParam String status, @RequestParam int page, @RequestParam int size, @RequestParam(required = false) String sort) {
        try {
            StatusTopicUFF statusEnum = StatusTopicUFF.valueOf(status);
            Pageable pageable = createPageable(page, size, sort);
            Page<TopicUFF> topicPage = topicUFFRepository.findByStatus(statusEnum, pageable);
            return topicPage.map(TopicUFFDTO::new);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid status: " + status);
        }
    }

    // /topics?status=OPEN&page=0&size=10&sort=title -> sort=title,asc
    // /topics?status=OPEN&page=0&size=10&sort=-createdAt -> sort=createdAt,desc
    // /topics?status=OPEN&page=0&size=10&sort=title,createdAt -> sort=title,asc&sort=createdAt,asc

    @GetMapping(params = "title")
    public Page<TopicUFFDTO> findByTitle(@RequestParam("title") String title, @RequestParam int page, @RequestParam int size, @RequestParam(required = false) String sort) {
        Pageable pageable = createPageable(page, size, sort);
        Page<TopicUFF> topicPage = topicUFFRepository.findByTitleContaining(title, pageable);
        return topicPage.map(TopicUFFDTO::new);
    }

    // /topics?title=Java&page=0&size=10&sort=title -> sort=title,asc
    // /topics?title=Java&page=0&size=10&sort=-createdAt -> sort=createdAt,desc
    // /topics?title=Java&page=0&size=10&sort=title,createdAt -> sort=title,asc&sort=createdAt,asc

    @GetMapping(params = "message")
    public Page<TopicUFFDTO> findByMessage(@RequestParam("message") String message, @RequestParam int page, @RequestParam int size, @RequestParam(required = false) String sort) {
        Pageable pageable = createPageable(page, size, sort);
        Page<TopicUFF> topicPage = topicUFFRepository.findByMessageContaining(message, pageable);
        return topicPage.map(TopicUFFDTO::new);
    }

    // /topics?message=Java&page=0&size=10&sort=title -> sort=title,asc
    // /topics?message=Java&page=0&size=10&sort=-createdAt -> sort=createdAt,desc
    // /topics?message=Java&page=0&size=10&sort=title,createdAt -> sort=title,asc&sort=createdAt,asc

    @GetMapping("/{id}")
    public ResponseEntity<TopicDetailDTO> getTopicById(@PathVariable Long id){
        Optional<TopicUFF> topic = topicUFFRepository.findById(id);
        return topic.map(topicUFF -> ResponseEntity.ok(new TopicDetailDTO(topicUFF))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST
    @PostMapping
    @Transactional
    @CacheEvict(value = "topicList", allEntries = true)
    public ResponseEntity<TopicUFFDTO> addTopic(@RequestBody @Valid TopicForm form, UriComponentsBuilder uriBuilder){
        TopicUFF topic = form.convert(courseRepository);
        topicUFFRepository.save(topic);
        URI uri = uriBuilder.path("/topics/{id}").buildAndExpand(topic.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicUFFDTO(topic));
    }

    // PUT
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

    // DELETE
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


    // SORT
    private Sort.Order parseSortProperty(String sortProperty) {
        Sort.Order order;
        if (sortProperty.startsWith("-")) {
            order = Sort.Order.desc(sortProperty.substring(1));
        } else {
            order = Sort.Order.asc(sortProperty);
        }
        return order;
    }

    private Pageable createPageable(int page, int size, String sort) {
        Sort sortCriteria = Sort.unsorted();

        if (sort != null && !sort.isEmpty()) {
            String[] sortProperties = sort.split(",");
            sortCriteria = Sort.by(Arrays.stream(sortProperties)
                    .map(this::parseSortProperty)
                    .collect(Collectors.toList()));
        }

        return PageRequest.of(page, size, sortCriteria);
    }
}


