package br.com.casadocodigo.security;

import java.security.Principal;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import br.com.casadocodigo.daos.SecurityDao;
import br.com.casadocodigo.models.SystemUser;

@Model
public class CurrentUser {
	
	@Inject
	private HttpServletRequest request;
	
	@Inject
	private SecurityDao securityDao;

	@Inject
	private SystemUser systemUser;
	
	@PostConstruct
	public void loadSystemUser() {
		
		Principal principal = request.getUserPrincipal();
		
		if (principal != null) {
			String email = this.request.getUserPrincipal().getName();
			this.systemUser = securityDao.findByEmail(email);			
		}
	}
	
	public SystemUser get() {
		return systemUser;
	}
	
	public boolean hasRole(String role) {
		return request.isUserInRole(role);
	}
}
