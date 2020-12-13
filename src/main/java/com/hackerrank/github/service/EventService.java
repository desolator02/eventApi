package com.hackerrank.github.service;

import com.hackerrank.github.model.Event;
import com.hackerrank.github.repository.GitRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;

@Component
public class EventService {
    @Autowired
    GitRepoService gitRepoService;

    public ResponseEntity<Event> saveEvent(Event event) {
        if (event.getId() != null) {
            Optional<Event> optionalEvent = gitRepoService.findById(event.getId());
            if (optionalEvent.isPresent()) {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<Event>(gitRepoService.save(event), HttpStatus.CREATED);
    }

    public ResponseEntity<Event> findEventById(Long id) {
        Optional<Event> optionalEvent = gitRepoService.findById(id);
        if (!optionalEvent.isPresent()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Event>(optionalEvent.get(), HttpStatus.OK);
    }

    public ResponseEntity<List<Event>> findAllEvent() {
        List<Event> eventList = gitRepoService.findAll();
        if (CollectionUtils.isEmpty(eventList)) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Event>>(eventList, HttpStatus.OK);
    }

    public ResponseEntity<Event> deleteAll(){
        gitRepoService.deleteAll();
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    public ResponseEntity<List<Event>> findByActorId(Long id) {
        List<Event> eventList = gitRepoService.findByActorId(id);
        if (CollectionUtils.isEmpty(eventList)) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(eventList, HttpStatus.OK);
    }

    public ResponseEntity<List<Event>> findByRepoId(Long id) {
        List<Event> eventList = gitRepoService.findByRepoId(id);
        if (CollectionUtils.isEmpty(eventList)) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(eventList, HttpStatus.OK);
    }

}
