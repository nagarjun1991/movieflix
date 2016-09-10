package io.nagarjun.movieflix.service;


import java.util.List;

import io.nagarjun.movieflix.entity.*;

public interface GenreService {
	
	public List<Genre> findAll();
	public Genre findById(String id);
	public Genre create(Genre emp);
	public Genre update(String id, Genre emp);
	public void delete(String id);


}


