package io.nagarjun.movieflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import io.nagarjun.movieflix.Exception.*;
import io.nagarjun.movieflix.entity.Cast;
import io.nagarjun.movieflix.repository.CastRepository;

@Service
public class CastServiceImp implements CastService  {
	@Autowired
	CastRepository repository;
	public List<Cast> findAll()
	{
		return repository.findAll();	
	}

	public Cast findById(String id)
	{
		Cast existing = repository.findById(id);
				if (existing == null) {
					throw new EntityNotFoundException("User with id:" + id + " not found");
				}
				return existing;	
	}

	@Transactional
	public Cast create(Cast usr)
	{
		Cast existing = repository.findByName(usr.getName());
 		if (existing != null) {
 			throw new EntityAlreadyExistsException("Name is already in use: " + usr.getName());
 		}
		 return repository.create(usr);
	}

	@Transactional
	public Cast update(String id, Cast usr)
	{
		Cast existing = repository.findById(id);
		 		if (existing == null) {
		 			throw new EntityNotFoundException("User with id:" + id + " not found");
		 		}
		 		return repository.update(usr);
	}

	@Transactional
	public void delete(String id)
	{
		Cast existing = repository.findById(id);
	 	if (existing == null) {
		 			throw new EntityNotFoundException("User with id:" + id + " not found");
		 		}
		 		repository.delete(existing);
	}

}
