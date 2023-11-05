package com.tutorial.tutorials.controller;

import com.tutorial.tutorials.model.TutorialModel;
import com.tutorial.tutorials.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TutorialController {
    @Autowired
    TutorialRepository tutorialRepository;

    @GetMapping("/tutorials")
    public ResponseEntity<List<TutorialModel>> getAllTutorials(@RequestParam(required = false) String title) {
        try {
            List<TutorialModel> tutorials = new ArrayList<TutorialModel>();

            if (title == null)
                tutorials.addAll(tutorialRepository.findAll());
            else
                tutorials.addAll(tutorialRepository.findByTitleContainingIgnoreCase(title));

            if (tutorials.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(tutorials, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/tutorials/{id}")
    public ResponseEntity<TutorialModel> getTutorialById(@PathVariable("id") long id) {
        Optional<TutorialModel> tutorialData = tutorialRepository.findById(id);

        return tutorialData.map(tutorialModel -> new ResponseEntity<>(tutorialModel, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/tutorials")
    public ResponseEntity<TutorialModel> createTutorial(@RequestBody TutorialModel tutorial) {
        try {
            TutorialModel _tutorial = tutorialRepository.save(new TutorialModel(tutorial.getTitle(), tutorial.getDescription(), tutorial.isPublished()));
            return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/tutorials/{id}")
    public ResponseEntity<TutorialModel> updateTutorial(@PathVariable("id") long id, @RequestBody TutorialModel tutorial) {
        Optional<TutorialModel> tutorialData = tutorialRepository.findById(id);

        if (tutorialData.isPresent()) {
            TutorialModel _tutorial = tutorialData.get();
            _tutorial.setTitle(tutorial.getTitle());
            _tutorial.setDescription(tutorial.getDescription());
            _tutorial.setPublished(tutorial.isPublished());
            return new ResponseEntity<>(tutorialRepository.save(_tutorial), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/tutorials/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
        try {
            tutorialRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
