package br.com.casadocodigo.models;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Autor implements Serializable, Comparator<Autor>{
	
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 
	
	private String nome; 

	
	public Autor() {
		
	}
	
	public Autor(String nome) {
		this.nome = nome;
	}
	
	public Autor(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override 
	public String toString() {
		return "Autor\nNome: " + getNome();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Autor other = (Autor) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public int compare(Autor o1, Autor o2) {
		return o1.getNome().compareTo(o2.getNome());
	}
	
	
}
