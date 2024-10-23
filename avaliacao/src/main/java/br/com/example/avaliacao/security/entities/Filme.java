package br.com.example.avaliacao.security.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="filmes")
public class Filme {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="ano_de_lancamento")
	private Integer anoDeLancamento;
	
	@Column(name="genero")
	private String genero;
	
	@Column(name="descricao")
	private String nomeFilme;
	
	@OneToOne
	@JoinColumn(name="fk_pessoa")
	private Pessoa pessoas;

	public Filme() {
	}

	public Filme(Integer id, Integer anoDeLancamento, String genero, String nomeFilme) {
		this.id = id;
		this.anoDeLancamento = anoDeLancamento;
		this.genero = genero;
		this.nomeFilme = nomeFilme;
	}

	public Integer getId() {
		return id;
	}

	public Integer getAnoDeLancamento() {
		return anoDeLancamento;
	}

	public String getGenero() {
		return genero;
	}

	public String nomeFilme() {
		return nomeFilme;
	}

	
	@Override
	public String toString() {
		return "Filme [id=" + id + ", anoDeLancamento=" + anoDeLancamento + ", genero=" + genero + ", nomeFilme="
				+ nomeFilme + "]";
	}

	public void setAnoDeLancamento(Integer anoDeLancamento2) {
	}

	public void setGenero(String genero2) {		
	}

	public void setDescricao(String nomeFilme2) {
	}

	public void setNomeFilme(String nomeFilme2) {
	}
	
	
	
	
	
}