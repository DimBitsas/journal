package com.personal.learning.journal.controller;

import com.personal.learning.journal.exception.EntryNotSavedException;
import com.personal.learning.journal.model.Entry;
import com.personal.learning.journal.service.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Controller
@Validated
public class journalController {

    private final EntryRepository service;

    @Autowired
    public journalController(EntryRepository service){this.service = service;}

    @GetMapping(path = "/")
    public String homePage(Model model){
        model.addAttribute("entries", service.findAll());
        return "home";
    }

    @GetMapping(path = "/entry")
    public String showEntryForm(){return "entry";}

    @GetMapping(path = "/createNewEntry")
    public String createNewEntry(@RequestParam("title")
                                     @Size(min = 4, message = "Title should have at least 4 characters")
                                     @NotBlank(message = "Title may not be blank") String title,
                                 @RequestParam("description")
                                    @Size(min = 10, message = "Description should have at least 10 characters")
                                         @NotBlank(message = "Description may not be blank") String description,
                                 @RequestParam("difficulty") @Min(1) @Max(10) int difficulty,
                                 @RequestParam("timeSpent") @Min(1) int timeSpent,
                                 @RequestParam("relevantTopics") String relevantTopics){

        Entry entryToBeSaved = new Entry(title,description,difficulty,timeSpent,relevantTopics);
        Entry savedEntry = service.save(entryToBeSaved);

        if(savedEntry == null){
            throw new EntryNotSavedException("Entry was not saved in the database");
        }

        return "entryCreated";
    }

    @GetMapping(path = "deleteEntry")
    public String deleteEntry(@RequestParam("entryId") Long entryId){
        if(!service.existsById(entryId)){
            return "entryNotExist";
        }
        service.deleteById(entryId);
        return "entryDeleted";
    }
}
