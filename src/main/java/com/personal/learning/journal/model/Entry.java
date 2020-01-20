package com.personal.learning.journal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 4, message = "Title should have at least 4 characters")
    @NotBlank(message = "Title may not be blank")
    private String title;

    @Size(min = 10, message = "Description should have at least 10 characters")
    @NotBlank(message = "Description may not be blank")
    private String description;

    @Min(1)
    @Max(10)
    private Integer difficulty;

    @Min(1)
    private Integer timeSpent;

    private String relevantTopics;

    protected Entry(){}

    public Entry(String title, String description, Integer difficulty, Integer timeSpent, String relevantTopics) {
        this.title = title;
        this.description = description;
        this.difficulty = difficulty;
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

    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
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
