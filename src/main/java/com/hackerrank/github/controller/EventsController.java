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
    public ResponseEntity<List<Event>> getEventsByRepoId(@PathVariable Long repoId) {
        //404
        //200
        return eventService.findByRepoId(repoId);
    }

    @GetMapping("/actors/{actorsId}")
    public ResponseEntity<List<Event>> getEventsByActorsId(@PathVariable Long actorsId) {
        //404
        //200
        return eventService.findByActorId(actorsId);
    }

    //6 point missing

    @GetMapping("/repos/{repoId}/actors/{actorId}")
    public ResponseEntity<List<Event>> filterByRepoIdAndActorId(
            @PathVariable Long repoId, @PathVariable Long actorId) {
        return eventService.findByRepoIdAndActorId(repoId,actorId);
    }
}
