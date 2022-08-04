package br.com.casadocodigo.daos;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.casadocodigo.models.Compra;

public class CompraDao implements Serializable {
	
	private final static long serialVersionUID = 1L;
	
	@PersistenceContext
	private EntityManager manager;
	
	public void salvar(Compra compra) {
		manager.persist(compra);
	}

	public Compra buscarPorUuid(String uuid) {
		return manager.createQuery("select c from Compra c where c.uuid =:uuid", Compra.class)
		.setParameter("uuid", uuid).getSingleResult();
	}

}
