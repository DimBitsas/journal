package com.personal.learning.journal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 4, message = "Title should have at least 4 characters")
    private String title;

    @Size(min = 10, message = "Description should have at least 10 characters")
    private String description;

    @Past(message = "Past date is required")
    private Date date;

    private Integer timeSpent;

    private String relevantTopics;

    protected Entry(){}

    public Entry(String title, String description, Date date, Integer timeSpent, String relevantTopics) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.timeSpent = timeSpent;
        this.relevantTopics = relevantTopics;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(Integer timeSpent) {
        this.timeSpent = timeSpent;
    }

    public String getRelevantTopics() {
        return relevantTopics;
    }

    public void setRelevantTopics(String relevantTopics) {
        this.relevantTopics = relevantTopics;
    }
}
