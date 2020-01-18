package com.personal.learning.journal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorldController {

    @GetMapping(path = "/hello")
    public String helloWorld(){return "hello";}
}
