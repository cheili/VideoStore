package net.claudeheili.videostore.controllers;

import org.springframework.web.bind.annotation.RestController;

import net.claudeheili.videostore.interfaces.HelloController;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloControllerImpl implements HelloController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}