package net.claudeheili.videostore.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class UserController {

  /* Maps to all HTTP actions by default (GET,POST,..)*/
  @RequestMapping("/users")
  public @ResponseBody String getUsers() {
    return "{\"users\":[{\"firstname\":\"Richard\", \"lastname\":\"Feynman\"}," +
           "{\"firstname\":\"Marie\",\"lastname\":\"Curie\"}]}";
  }
}