package io.nagarjun.movieflix.service;

import java.util.List;
import java.util.Map;

 import io.nagarjun.movieflix.entity.*;
public interface MovieService {
	
	 
		 
	 	public List<Movie> findAll();
	 
	 	public Movie findById(String id);
	 	
	 	public List<Movie> findByArguments(Map<String, String> params);
	 	
	 	public Movie create(Movie emp);
	 
	 	public Movie update(String id, Movie emp);
	 
	 	public void delete(String id);

}
