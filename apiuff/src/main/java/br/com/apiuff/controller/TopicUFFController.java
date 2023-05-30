package br.com.apiuff.controller;

import br.com.apiuff.controller.dto.TopicUFFDTO;
import br.com.apiuff.repository.TopicUFFRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class TopicUFFController {
    @Autowired
    private TopicUFFRepository topicUFFRepository;

    @RequestMapping("/topics")
    public List<TopicUFFDTO> listTopics(){
        return TopicUFFDTO.convert(topicUFFRepository.findAll());
    }

}
