package io.nagarjun.movieflix.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import io.nagarjun.movieflix.entity.Cast;

@Repository
public class CastRepositoryImp implements CastRepository{
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Cast> findAll() {
		TypedQuery<Cast> query = em.createNamedQuery("Cast.findAll", Cast.class);
		return query.getResultList();
     }
	@Override
	public Cast findById(String id) {
		return em.find(Cast.class, id);
	}

	@Override
	public Cast findByName(String name) {
		TypedQuery<Cast> query = em.createNamedQuery("Cast.findByName", Cast.class);
		query.setParameter("pName", name);
		List<Cast> casts = query.getResultList();
		if (casts != null && casts.size() == 1) {
			return casts.get(0);
		}
		return null;
	}

	@Override
	public Cast create(Cast usr) {
		em.persist(usr);
		return usr;
	}

	@Override
	public Cast update(Cast usr) {
		return em.merge(usr);
	}

	@Override
	public void delete(Cast usr) {
		em.remove(usr);
	}
}
