package com.tutorial.tutorials.repository;

import com.tutorial.tutorials.model.TutorialModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TutorialRepository extends JpaRepository<TutorialModel, Long> {
    List<TutorialModel> findByPublished(boolean published);

    List<TutorialModel> findByTitleContainingIgnoreCase(String title);
}
