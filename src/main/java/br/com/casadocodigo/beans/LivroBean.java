package br.com.casadocodigo.beans;

import java.io.IOException;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;
import javax.transaction.Transactional;

import br.com.casadocodigo.daos.AutorDao;
import br.com.casadocodigo.daos.LivroDao;
import br.com.casadocodigo.infra.FileSaver;
import br.com.casadocodigo.models.Autor;
import br.com.casadocodigo.models.Livro;

@Named
@RequestScoped
public class LivroBean {
	
	private Livro livro = new Livro();
	
	@Inject
	private LivroDao livroDao;
	
	@Inject
	private AutorDao autorDao;
	
	@Inject
	private FacesContext facesContext;
	
	private Part capaLivro;
	
	
	@Transactional
	public String salvar() throws IOException {
		
		livroDao.salvar(livro);
		FileSaver fileSaver = new FileSaver();
		String relativePath = fileSaver.write(capaLivro, "livros");
		livro.setCapaPath(relativePath);
		
		facesContext.getExternalContext().getFlash().setKeepMessages(true);
		facesContext.addMessage(null, new FacesMessage("Livro cadastrado com sucesso!"));
		
		return "/livros/lista?faces-redirect=true";
		
	}

	
	
	public Livro getLivro() {
		return livro;
	}
	
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	public List<Autor> getAutores() {
		return autorDao.listar();
	}
	
	public Part getCapaLivro() {
		return capaLivro;
	}
	
	public void setCapaLivro(Part capaLivro) {
		this.capaLivro = capaLivro;
	}
	
	

}
