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
	private String anoDeLancamento;
	
	@Column(name="genero")
	private String genero;
	
	@Column(name="descricao")
	private String descricao;
	
	@OneToOne
	@JoinColumn(name="fk_pessoa")
	private Pessoa pessoas;

	public Filme() {
	}

	public Filme(Integer id, String anoDeLancamento, String genero, String descricao) {
		this.id = id;
		this.anoDeLancamento = anoDeLancamento;
		this.genero = genero;
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public String getAnoDeLancamento() {
		return anoDeLancamento;
	}

	public String getGenero() {
		return genero;
	}

	public String getDescricao() {
		return descricao;
	}

	
	@Override
	public String toString() {
		return "Filme [id=" + id + ", anoDeLancamento=" + anoDeLancamento + ", genero=" + genero + ", descricao="
				+ descricao + "]";
	}
	
	
	
	
	
}