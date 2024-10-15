package br.com.example.avaliacao.security.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="pessoa")
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="nome_completo")
	private String nomeCompleto;
	
	@Column(name="filme")
	private String filme;
	
	
	public Pessoa() {
	}

	public Pessoa(Integer id, String nomeCompleto, String filme) {
		this.id = id;
		this.nomeCompleto = nomeCompleto;
		this.filme = filme;
	
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getFilme() {
		return filme;
	}

	public void setFilme(String filme) {
		this.filme = filme;
	}

	

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nomeCompleto=" + nomeCompleto + ", filme=" + filme + ", serie=" + "]";
	}
}
