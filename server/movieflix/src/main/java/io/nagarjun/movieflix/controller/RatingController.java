package io.nagarjun.movieflix.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.nagarjun.movieflix.entity.*;
import io.nagarjun.movieflix.service.*;

@RestController
@RequestMapping(value = "ratings", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class RatingController {
	
	 	@Autowired
	 	RatingService service;
	 
	 	@RequestMapping(method = RequestMethod.GET)
	 	public double findByArguments(@RequestParam Map<String, String> params) {
	 		return service.findByArguments(params);
	 	}
	 
	 	@RequestMapping(method = RequestMethod.GET, path = "{id}")
	 	public Rating findById(@PathVariable("id") String id) {
	 		return service.findById(id);
	 	}
	 
	 	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	 	public Rating create(@RequestBody Rating rating, @RequestParam Map<String, String> params) {
	 		return service.create(params,rating);
	 	}
	 
	 	@RequestMapping(method = RequestMethod.PUT, path = "{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	 	public Rating update(@PathVariable("id") String id, @RequestBody Rating rating) {
	 		return service.update(id, rating);
	 	}
	 	@RequestMapping(method = RequestMethod.DELETE, path = "{id}")
	 	public void delete(@PathVariable("id") String id) {
	 		service.delete(id);
	 	}
}
	 