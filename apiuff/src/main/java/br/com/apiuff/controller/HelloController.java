package br.com.apiuff.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class HelloController {

    @RequestMapping("/")
    @ResponseBody
    public String hello() {
        return "Hello, world!";
    }
}
