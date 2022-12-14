package br.com.casadocodigo.resources;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.providers.jaxb.Wrapped;

import br.com.casadocodigo.daos.LivroDao;
import br.com.casadocodigo.models.Livro;

@Path("livros")
public class LivroResource {
	
	@Inject
	private LivroDao livroDao;
	
	@GET
	@Path("lancamentos")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Wrapped(element = "livros")
	public List<Livro> lancamentos() {
		return livroDao.lancamentos();
	}
	
	

}
