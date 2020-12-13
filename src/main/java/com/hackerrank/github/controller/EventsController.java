package com.hackerrank.github.controller;

import com.hackerrank.github.model.Event;
import com.hackerrank.github.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/events")
public class EventsController {

    @Autowired
    EventService eventService;

    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        // 400 for same id
        //201 for success
        return eventService.saveEvent(event);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> findEvent(@PathVariable Long id) {
        //404 for no record
        //200 for success
        return eventService.findEventById(id);
    }

    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents() {
        return eventService.findAllEvent();
    }

    @GetMapping("/repos/{repoId}")
    public void getEventsByRepoId(@PathVariable String repoId) {
        //404
        //200
        //TODO:
    }

    @GetMapping("/actors/{actorsId}")
    public void getEventsByActorsId(@PathVariable String actorsId) {
//404
        //200
        //TODO:
    }

    //6 point missing
}
