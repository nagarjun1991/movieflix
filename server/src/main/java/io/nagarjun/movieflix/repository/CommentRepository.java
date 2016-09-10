package io.nagarjun.movieflix.repository;

import java.util.List;
import java.util.Map;

import io.nagarjun.movieflix.entity.*;

public interface CommentRepository {
 
     public List<Comment> findByArguments(Map<String, String> params);
	 public Comment findById(String id);
	 public Comment create(Comment comment);
	 public Comment update(Comment emp);
	 public void delete(Comment emp);
}