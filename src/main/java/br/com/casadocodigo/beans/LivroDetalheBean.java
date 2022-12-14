package br.com.casadocodigo.beans;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.casadocodigo.daos.LivroDao;
import br.com.casadocodigo.models.Livro;

@Model
public class LivroDetalheBean {

	@Inject
	private LivroDao livroDao;
	
	private Livro livro;
	
	private Integer id;
	
	public void carregarDetalhe() {
		setLivro(livroDao.buscarPorId(id));
	}
	
	public Livro getLivro() {
		return livro;
	}
	
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
}
