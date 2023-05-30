package br.com.apiuff.controller;

import br.com.apiuff.entities.Course;
import br.com.apiuff.entities.TopicUFF;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicUFFController {

    @RequestMapping("/topics")
    public List<TopicUFF> list() {
        TopicUFF topic = new TopicUFF("Dúvida", "Dúvida com Spring", new Course("Spring", "Programação"));
        return Arrays.asList(topic, topic, topic);
    }
}
