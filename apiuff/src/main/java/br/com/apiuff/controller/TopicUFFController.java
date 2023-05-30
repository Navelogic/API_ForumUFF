package br.com.apiuff.controller;

import br.com.apiuff.controller.dto.TopicUFFDTO;
import br.com.apiuff.entities.TopicUFF;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;


@RestController
public class TopicUFFController {

    @RequestMapping("/topics")
    public List<TopicUFFDTO> list() {
        TopicUFF topicUFF = new TopicUFF();
        return TopicUFFDTO.convert(Arrays.asList(topicUFF, topicUFF, topicUFF));
    }

}
