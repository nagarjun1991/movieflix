package io.nagarjun.movieflix.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import io.nagarjun.movieflix.entity.Genre;

@Repository
public class GenreRepositoryImp implements GenreRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Genre> findAll() {
		TypedQuery<Genre> query = em.createNamedQuery("Genre.findAll", Genre.class);
		return query.getResultList();
     }
	@Override
	public Genre findById(String id) {
		return em.find(Genre.class, id);
	}

	@Override
	public Genre findByKind(String name) {
		TypedQuery<Genre> query = em.createNamedQuery("Genre.findByName", Genre.class);
		query.setParameter("pkind", name);
		List<Genre> casts = query.getResultList();
		if (casts != null && casts.size() == 1) {
			return casts.get(0);
		}
		return null;
	}

	@Override
	public Genre create(Genre usr) {
		em.persist(usr);
		return usr;
	}

	@Override
	public Genre update(Genre usr) {
		return em.merge(usr);
	}

	@Override
	public void delete(Genre usr) {
		em.remove(usr);
	}
}