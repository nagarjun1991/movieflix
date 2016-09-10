package io.nagarjun.movieflix.service;
import java.util.List;
import io.nagarjun.movieflix.entity.*;
public interface UserService {

	public List<User> findAll();

	public User findById(String id);

	public User create(User emp);

	public User update(String id, User emp);

	public void delete(String id);

}
