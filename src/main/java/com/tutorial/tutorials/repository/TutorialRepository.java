package com.tutorial.tutorials.repository;

import com.tutorial.tutorials.model.TutorialModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface TutorialRepository extends MongoRepository<TutorialModel, Long> {
    List<TutorialModel> findByPublished(boolean published);

    List<TutorialModel> findByTitleContainingIgnoreCase(String title);

    void deleteById(String id);

    Optional<TutorialModel> findById(String id);
}
