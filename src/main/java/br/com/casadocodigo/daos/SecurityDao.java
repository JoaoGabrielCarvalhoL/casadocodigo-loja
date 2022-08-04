package br.com.casadocodigo.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.casadocodigo.models.SystemUser;

public class SecurityDao {
	
	@PersistenceContext
	private EntityManager manager;

	public SystemUser findByEmail(String email) {
		String jpql = "select su from SystemUser su where su.email =:email";
		return manager.createQuery(jpql, SystemUser.class).
				setParameter("email", email)
				.getSingleResult();
	}

}
