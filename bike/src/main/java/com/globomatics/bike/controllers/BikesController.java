package com.globomatics.bike.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.globomatics.bike.models.Bike;
import com.globomatics.bike.repositories.BikeRepository;

@RestController
@RequestMapping("/api/v1/bikes")
public class BikesController {
	/**
	 * Inject bike repository in to the controller
	 */
	
	@Autowired
	private BikeRepository bikeRepository;
    /**
     * List of bike in an Array list
     * @return
     */
	@GetMapping
	public List<Bike> list() {
		return bikeRepository.findAll();
	}
	
	/**
	 * Create a bike
	 * @param bike
	 */
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody Bike bike) {
		bikeRepository.save(bike);
		
	}
	
	/**
	 * Create a get method
	 * @param id
	 * @return a single bike detail by passing id
	 */
	@GetMapping("/{id}")
	public Bike get(@PathVariable("id") long id) {
		return bikeRepository.getOne(id);
		
	}
}
