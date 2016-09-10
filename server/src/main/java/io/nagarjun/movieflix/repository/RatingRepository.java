package io.nagarjun.movieflix.repository;

import java.util.List;
import java.util.Map;

import io.nagarjun.movieflix.entity.*;

public interface RatingRepository {
	
 	public double findByArguments(Map<String, String> params);
    public Rating findById(String id);
 	public List<Rating> findByUserIdMovieId(String userId, String movieId);
	public Rating create(Rating rating);
 	public Rating update(Rating rating);
 	public void delete(Rating rating);
	
}
