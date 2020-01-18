package com.personal.learning.journal.controller;

import com.personal.learning.journal.service.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class journalController {

    private final EntryRepository service;

    @Autowired
    public journalController(EntryRepository service){this.service = service;}

    @GetMapping(path = "/")
    public String homePage(Model model){
        model.addAttribute("entries", service.findAll());
        return "home";
    }
}
