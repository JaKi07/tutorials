package com.tutorial.tutorials.model;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "tutorials")
public class Tutorial {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Getter
    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "published")
    private Boolean published;


}
