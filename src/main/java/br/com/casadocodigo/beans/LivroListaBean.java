package br.com.casadocodigo.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.casadocodigo.daos.LivroDao;
import br.com.casadocodigo.models.Livro;

@Model
public class LivroListaBean {
	
	@Inject
	private LivroDao dao;
	
	private List<Livro> livros = new ArrayList<Livro>();
	
	public List<Livro> getLivros() {
		this.livros = dao.listar();
		return livros;
	}
	

}
