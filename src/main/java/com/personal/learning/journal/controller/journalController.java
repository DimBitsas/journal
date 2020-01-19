package com.personal.learning.journal.controller;

import com.personal.learning.journal.model.Entry;
import com.personal.learning.journal.service.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping(path = "/createNewEntry")
    public String showCreateNewEntryForm(){return "createNewEntry";}

    @GetMapping(path = "/createNewEntryValidation")
    public String createNewEntry(@RequestParam("title") String title, @RequestParam("description") String description,
                                 @RequestParam("difficulty") int difficulty, @RequestParam("timeSpent") int timeSpent,
                                 @RequestParam("relevantTopics") String relevantTopics){

        System.out.println(title);
        System.out.println(description);
        System.out.println(difficulty);
        System.out.println(timeSpent);
        System.out.println(relevantTopics);

        Entry entryToBeSaved = new Entry(title,description,difficulty,timeSpent,relevantTopics);
        Entry savedEntry = service.save(entryToBeSaved);

        return "newEntryCreated";
    }
}
