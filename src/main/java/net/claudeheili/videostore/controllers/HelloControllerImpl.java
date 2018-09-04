package net.claudeheili.videostore.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.claudeheili.videostore.interfaces.HelloController;


@RestController
public class HelloControllerImpl implements HelloController {

	@CrossOrigin
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
    
}