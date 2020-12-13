package com.hackerrank.github.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;

@RestController
@RequestMapping(value = "/erase")
public class ResourcesController {

    @DeleteMapping
    public ResponseEntity deleteAll(){
        //200 for success
        return null;
    }


}
