package io.nagarjun.movieflix.repository;
import java.util.List;
import io.nagarjun.movieflix.entity.*;

public interface UserRepository {
	
	public List<User> findAll();
	public User findById(String id);
	public User findByEmail(String email);
	public User create(User usr);
	public User update(User usr);
	public void delete(User usr);

}

