package br.com.casadocodigo.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SystemRole implements Serializable{

private static final long serialVersionUID = 1L;
	
	@Id
	private String name;
	
	public SystemRole() {
		
	}
	
	public SystemRole(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override 
	public String toString() {
		return "System Role\nName: " + getName(); 
	}
}
