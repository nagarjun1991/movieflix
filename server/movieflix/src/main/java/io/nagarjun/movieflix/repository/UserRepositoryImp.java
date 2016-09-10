package io.nagarjun.movieflix.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import io.nagarjun.movieflix.entity.*;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImp implements UserRepository{
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<User> findAll() {
		TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class);
		return query.getResultList();
     }
	@Override
	public User findById(String id) {
		return em.find(User.class, id);
	}

	@Override
	public User findByEmail(String email) {
		TypedQuery<User> query = em.createNamedQuery("User.findByEmail", User.class);
		query.setParameter("pEmail", email);
		List<User> Users = query.getResultList();
		if (Users != null && Users.size() == 1) {
			return Users.get(0);
		}
		return null;
	}

	@Override
	public User create(User usr) {
		em.persist(usr);
		return usr;
	}

	@Override
	public User update(User usr) {
		return em.merge(usr);
	}

	@Override
	public void delete(User usr) {
		em.remove(usr);
	}
}








