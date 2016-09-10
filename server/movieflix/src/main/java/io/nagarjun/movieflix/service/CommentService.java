package io.nagarjun.movieflix.service;

import java.util.List;
import java.util.Map;
import io.nagarjun.movieflix.entity.*;
public interface CommentService {
	
	 	public List<Comment> findByArguments(Map<String, String> params);
	 
	 	public Comment findById(String id);
	 
	 	public Comment create(Map<String, String> params, Comment comment);
	 
	 	public Comment update(String id, Comment emp);
	 
	 	public void delete(String id);

}
