package com.api.bibliotecalivros.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "status")
public class ProdutoStatus {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private int disponivel;
	
	private int reservado;
	
	private int alugado;

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDisponivel() {
		return disponivel;
	}

	public void setDisponivel(int disponivel) {
		this.disponivel = disponivel;
	}

	public int getReservado() {
		return reservado;
	}

	public void setReservado(int reservado) {
		this.reservado = reservado;
	}

	public int getAlugado() {
		return alugado;
	}

	public void setAlugado(int alugado) {
		this.alugado = alugado;
	}
	
	
	
	
	
}
