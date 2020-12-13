package com.hackerrank.github.controller;

import com.hackerrank.github.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/erase")
public class ResourcesController {
    @Autowired
    EventService eventService;

    @DeleteMapping
    public ResponseEntity deleteAll() {
        //200 for success
        //TODO: delete
        return eventService.deleteAll();
    }

}
