package io.nagarjun.movieflix.repository;

import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import io.nagarjun.movieflix.entity.*;
	 
@Repository
public class RatingRepositoryImp implements RatingRepository {
	 
 	@PersistenceContext
 	private EntityManager em;

 	@Override
	public double findByArguments(Map<String, String> params) {
		TypedQuery<Double> query;
		if(params.get("movieId")!=null)
		{
			query = em.createNamedQuery("Rating.findAvgByMovieId", Double.class);
			query.setParameter("pMovieId", params.get("movieId"));
		}	
		else	
			query = em.createNamedQuery("Rating.findAll", Double.class);
	    	double avg = query.getSingleResult();
	 		return avg;
	 	}
	 
	@Override
	public List<Rating> findByUserIdMovieId(String userId, String movieId) {
		TypedQuery<Rating> query = em.createNamedQuery("Rating.findByUserIdMovieId", Rating.class);
		query.setParameter("pUserId", userId); 
		query.setParameter("pMovieId", movieId);
		return query.getResultList();
		}
	 	
	@Override
	public Rating findById(String id) {
		return em.find(Rating.class, id);
	}
	 	
	@Override
	public Rating create(Rating rating) {
		em.persist(rating);
		return rating;
	}
	 
	@Override
	public Rating update(Rating rating) {
		return em.merge(rating);
	}
	
	@Override
	public void delete(Rating rating) {
		em.remove(rating);
	}
 }
