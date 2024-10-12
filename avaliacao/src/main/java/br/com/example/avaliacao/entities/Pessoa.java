package br.com.example.avaliacao.entities;

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
	
	@Column(name="serie")
	private String serie;

	public Pessoa() {
	}

	public Pessoa(Integer id, String nomeCompleto, String filme, String serie) {
		this.id = id;
		this.nomeCompleto = nomeCompleto;
		this.filme = filme;
		this.serie = serie;
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

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nomeCompleto=" + nomeCompleto + ", filme=" + filme + ", serie=" + serie + "]";
	}
}
