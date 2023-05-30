package br.com.apiuff.controller;

import br.com.apiuff.entities.Course;
import br.com.apiuff.entities.TopicUFF;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
public class TopicUFFController {

    @RequestMapping("/topics")
    @ResponseBody
    public List<TopicUFF> list() {
        TopicUFF topic = new TopicUFF("Dúvida", "Dúvida com Spring", new Course("Spring", "Programação"));
        return Arrays.asList(topic, topic, topic);
    }
}
