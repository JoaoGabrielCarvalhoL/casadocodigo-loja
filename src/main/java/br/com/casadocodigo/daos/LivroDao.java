package br.com.casadocodigo.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.casadocodigo.models.Livro;


public class LivroDao {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void salvar(Livro livro) {
		manager.persist(livro);
	}

	public List<Livro> listar() {
		
        String jpql = "select distinct(l) from Livro l "
                + " join fetch l.autores";
        return manager.createQuery(jpql, Livro.class).getResultList();
        
		//return manager.createQuery("select l from Livro l", Livro.class).getResultList() ;
    }

	public List<Livro> ultimosLancamentos() {
		String jpql = "select l from Livro l order by l.id desc";
		return manager.createQuery(jpql, Livro.class)
				.setMaxResults(5)
				.getResultList();
	}
	
	public List<Livro> lancamentos() {
		String jpql = "select l from Livro l join fetch l.autores"; 
		return manager.createQuery(jpql, Livro.class).getResultList();
	}

	public List<Livro> demaisiLivros() {
		String jpql = "select l from Livro l order by l.id desc";
		return manager.createQuery(jpql, Livro.class).setFirstResult(5).getResultList();
	}

	public Livro buscarPorId(Integer id) {
		String jpql = "select l from Livro l join fetch l.autores where l.id = :id";
		return manager.createQuery(jpql, Livro.class).setParameter("id", id).getSingleResult();
	}
}
