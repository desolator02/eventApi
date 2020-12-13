package com.hackerrank.github.service;

import com.hackerrank.github.model.Event;
import com.hackerrank.github.repository.GitRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EventService {
    @Autowired
    GitRepoService gitRepoService;

    public ResponseEntity<Event> saveEvent(Event event){
        if(event.getId() != null){
            Optional<Event> optionalEvent = gitRepoService.findById(event.getId());
            if(optionalEvent.isPresent()){
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
        }

        return new ResponseEntity<Event>(gitRepoService.save(event), HttpStatus.CREATED);
    }
}
