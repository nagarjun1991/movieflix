package io.nagarjun.movieflix.repository;

import java.util.List;

import io.nagarjun.movieflix.entity.Genre;

public interface GenreRepository {
	
	public List<Genre> findAll();
    public Genre findById(String id);
	public Genre findByKind(String name);
	public Genre create(Genre usr);
	public Genre update(Genre usr);
	public void delete(Genre usr);
}
