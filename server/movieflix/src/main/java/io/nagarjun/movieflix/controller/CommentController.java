package io.nagarjun.movieflix.controller;

import java.util.List;
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
@RequestMapping(value = "comments", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CommentController {
	 
	 	@Autowired
	 	CommentService service;
	 	
	 	@RequestMapping(method = RequestMethod.GET)
	 	public List<Comment> findAll(@RequestParam Map<String, String> params) {
	 		return service.findByArguments(params);
	 	}
	 
	 	@RequestMapping(method = RequestMethod.GET, path = "{id}")
	 	public Comment findById(@PathVariable("id") String id) {
	 		return service.findById(id);
	 	}
	 
	 	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	 	public Comment create(@RequestBody Comment comment, @RequestParam Map<String, String> params) {
	 		return service.create(params, comment);
	 	}
	 
	 	@RequestMapping(method = RequestMethod.PUT, path = "{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	 	public Comment update(@PathVariable("id") String id, @RequestBody Comment comment) {
	 		return service.update(id, comment);
	 	}
	 
	 	@RequestMapping(method = RequestMethod.DELETE, path = "{id}")
	 	public void delete(@PathVariable("id") String id) {
	 		service.delete(id);
	 	}
}
