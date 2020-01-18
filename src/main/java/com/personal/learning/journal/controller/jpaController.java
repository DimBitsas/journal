package com.personal.learning.journal.controller;

import com.personal.learning.journal.model.Entry;
import com.personal.learning.journal.service.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class jpaController {

    private final EntryRepository service;

    @Autowired
    public jpaController(EntryRepository service){this.service = service;}

    @GetMapping("jpa/entries")
    public List<Entry> retrieveAllEntries(){return service.findAll();}
}
