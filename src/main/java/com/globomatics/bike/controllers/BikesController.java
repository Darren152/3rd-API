package com.globomatics.bike.controllers;

import com.globomatics.bike.models.Bike;
import com.globomatics.bike.repositories.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/bikes")
public class BikesController {

    @Autowired
    private BikeRepository bikeRepository;

    @GetMapping
    public List<Bike> list(){
        return bikeRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Bike bike){
        bikeRepository.save(bike);
    }

    @GetMapping("/{id}")
    public Bike get(@PathVariable("id") long id){
        return bikeRepository.getOne(id);
    }

//    @RequestMapping(value = "/api/v1/bikes", method = RequestMethod.GET)
//    public List<Bike> list(){
//        return bikeRepository.findAll();
//    }
//
//    @RequestMapping(value = "/api/v1/bikes", method = RequestMethod.POST)
//    public void create(@RequestBody Bike bike){
//        bikeRepository.save(bike);
//    }
//
//    @RequestMapping(value = "/api/v1/bikes/{id}", method = RequestMethod.GET)
//    public Bike get(@PathVariable Long id){
//        return bikeRepository.getOne(id);
//    }

}
