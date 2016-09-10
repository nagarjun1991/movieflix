package io.nagarjun.movieflix.repository;


import java.util.List;
import java.util.Map;
import io.nagarjun.movieflix.entity.*;

public interface MovieRepository {

 	public List<Movie> findAll();
 	public Movie findById(String id);
 	public List<Movie> findByArguments(Map<String, String> params);
    public Movie create(Movie movie);
 	public Movie update(Movie movie);
 	public void delete(Movie movie);
 	public Movie findByTitle(String title);
}
