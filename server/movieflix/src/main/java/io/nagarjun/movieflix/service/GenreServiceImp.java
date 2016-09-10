package io.nagarjun.movieflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import io.nagarjun.movieflix.Exception.*;
import io.nagarjun.movieflix.entity.*;
import io.nagarjun.movieflix.repository.*;

@Service
public class GenreServiceImp {
	
	@Autowired
	GenreRepository repository;
	
	public List<Genre> findAll()
	{
		return repository.findAll();	
	}

	public Genre findById(String id)
	{
		Genre existing = repository.findById(id);
				if (existing == null) {
					throw new EntityNotFoundException("User with id:" + id + " not found");
				}
				return existing;	
	}

	@Transactional
	public Genre create(Genre usr)
	{
		Genre existing = repository.findByKind(usr.getKind());
		 		if (existing != null) {
		 			throw new EntityAlreadyExistsException("Kind is already in use: " + usr.getKind());
		 		}
		 		return repository.create(usr);
	}

	@Transactional
	public Genre update(String id, Genre usr)
	{
		Genre existing = repository.findById(id);
		 		if (existing == null) {
		 			throw new EntityNotFoundException("Kind with id:" + id + " not found");
		 		}
		 		return repository.update(usr);
	}

	@Transactional
	public void delete(String id)
	{
		Genre existing = repository.findById(id);
	 	if (existing == null) {
		 			throw new EntityNotFoundException("User with id:" + id + " not found");
		 		}
		 		repository.delete(existing);
	}
}
