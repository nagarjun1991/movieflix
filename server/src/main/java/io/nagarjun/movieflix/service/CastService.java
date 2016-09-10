package io.nagarjun.movieflix.service;

import java.util.List;

import io.nagarjun.movieflix.entity.*;

public interface CastService {
	public List<Cast> findAll();

	public Cast findById(String id);

	public Cast create(Cast emp);

	public Cast update(String id, Cast emp);

	public void delete(String id);


}
