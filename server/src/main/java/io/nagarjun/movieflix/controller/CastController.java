package io.nagarjun.movieflix.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.nagarjun.movieflix.entity.*;
import io.nagarjun.movieflix.service.*;

@RestController
@RequestMapping(value = "casts",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CastController {
	
	@Autowired
	CastService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Cast> findAll() {
		return service.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "{id}")
	public Cast findOne(@PathVariable("id") String id) {
		return service.findById(id);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Cast create(@RequestBody Cast usr) {
		return service.create(usr);
	}

	@RequestMapping(method = RequestMethod.PUT, path = "{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Cast update(@PathVariable("id") String id, @RequestBody Cast usr) {
		return service.update(id, usr);
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "{id}")
	public void delete(@PathVariable("id") String id) {
		service.delete(id);
	}
}
