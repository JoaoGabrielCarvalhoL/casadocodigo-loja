package br.com.casadocodigo.models;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

@Entity
public class Compra {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Usuario usuario; 
	
	private String itens;
	
	private String uuid;
	
	private BigDecimal total;
	
	public Compra() {
		
	}

	public Integer getId() {
		return id;
	}

	public String getItens() {
		return itens;
	}

	public void setItens(String itens) {
		this.itens = itens;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
		
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uUID) {
		uuid = uUID;
	}
	
	@PrePersist
	public void createUUID() {
		this.uuid = UUID.randomUUID().toString();
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

}
