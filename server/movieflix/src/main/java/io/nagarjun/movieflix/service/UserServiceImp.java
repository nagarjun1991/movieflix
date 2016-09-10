package io.nagarjun.movieflix.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import io.nagarjun.movieflix.entity.*;
import io.nagarjun.movieflix.Exception.*;
import io.nagarjun.movieflix.repository.*;

@Service
public class UserServiceImp implements UserService {
	
	@Autowired
	UserRepository repository;
	public List<User> findAll()
	{
		return repository.findAll();	
	}

	public User findById(String id)
	{
		User existing = repository.findById(id);
				if (existing == null) {
					throw new EntityNotFoundException("User with id:" + id + " not found");
				}
				return existing;	
	}

	@Transactional
	public User create(User usr)
	{
		User existing = repository.findByEmail(usr.getEmail());
		 		if (existing != null) {
		 			throw new EntityAlreadyExistsException("Email is already in use: " + usr.getEmail());
		 		}
		 		return repository.create(usr);
	}

	@Transactional
	public User update(String id, User usr)
	{
		User existing = repository.findById(id);
		 		if (existing == null) {
		 			throw new EntityNotFoundException("User with id:" + id + " not found");
		 		}
		 		return repository.update(usr);
	}

	@Transactional
	public void delete(String id)
	{
		User existing = repository.findById(id);
	 	if (existing == null) {
		 			throw new EntityNotFoundException("User with id:" + id + " not found");
		 		}
		 		repository.delete(existing);
	}
}
