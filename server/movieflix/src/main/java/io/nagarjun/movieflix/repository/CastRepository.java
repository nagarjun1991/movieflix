package io.nagarjun.movieflix.repository;

import java.util.List;

import io.nagarjun.movieflix.entity.*;

public interface CastRepository {
	
	public List<Cast> findAll();
	public Cast findById(String id);
	public Cast findByName(String name);
	public Cast create(Cast usr);
	public Cast update(Cast usr);
	public void delete(Cast usr);
}
