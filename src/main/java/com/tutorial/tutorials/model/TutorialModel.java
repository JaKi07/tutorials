package com.tutorial.tutorials.model;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "tutorials")
public class TutorialModel {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Getter
    @Column(name = "title")
    private String title;

    @Getter
    @Column(name = "description")
    private String description;

    @Column(name = "published")
    private Boolean published;

    public TutorialModel() {

    }

    public TutorialModel(String title, String description, boolean published) {
        this.title = title;
        this.description = description;
        this.published = published;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean isPublished) {
        this.published = isPublished;
    }

    @Override
    public String toString() {
        return "Tutorial [id=" + id + ", title=" + title + ", desc=" + description + ", published=" + published + "]";
    }
}
