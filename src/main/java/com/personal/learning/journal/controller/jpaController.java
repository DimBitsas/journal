package com.personal.learning.journal.controller;

import com.personal.learning.journal.model.Entry;
import com.personal.learning.journal.service.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class jpaController {

    private final EntryRepository service;

    @Autowired
    public jpaController(EntryRepository service){this.service = service;}

    @GetMapping("jpa/entries")
    public List<Entry> retrieveAllEntries(){return service.findAll();}

    @GetMapping("jpa/entry/{id}")
    public Entry retrieveEntry(@PathVariable Long id){
        Optional<Entry> entry = service.findById(id);

        if(!entry.isPresent()){
            //throw new EntryNotFoundException("id-"+id);
        }

        return entry.get();
    }

    @PostMapping("jpa/entries")
    public void createEntry(@Valid @RequestBody Entry entry){
        Entry savedEntry = service.save(entry);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id")
                .buildAndExpand(savedEntry.getId())
                .toUri();

        ResponseEntity.created(location).build();
    }

    @DeleteMapping("jpa/entries/{id}")
    public void deleteEntry(@PathVariable Long id){service.deleteById(id);}
}
