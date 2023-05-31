package br.com.apiuff.controller;

import br.com.apiuff.controller.dto.TopicUFFDTO;
import br.com.apiuff.controller.form.TopicForm;
import br.com.apiuff.entities.TopicUFF;
import br.com.apiuff.repository.CourseRepository;
import br.com.apiuff.repository.TopicUFFRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/apiuff/topics")
public class TopicUFFController {

    @Autowired
    private TopicUFFRepository topicUFFRepository;

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping
    public List<TopicUFFDTO> listTopics(String couseName){
        if(couseName == null){
            List<TopicUFF> topics = topicUFFRepository.findAll();
            return TopicUFFDTO.convert(topics);
        } else {
            List<TopicUFF> topics = topicUFFRepository.findByCourseName(couseName);
            return TopicUFFDTO.convert(topics);
        }
    }

    @PostMapping
    public void addTopic(@RequestBody TopicForm form){
        TopicUFF topic = form.convert(courseRepository);
        topicUFFRepository.save(topic);
    }
}
