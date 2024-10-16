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
@Table(name="avaliacoes")
public class Avaliacao {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="classsificao")
	private String classificacao;
	
	@Column(name="review")
	private String review;
	
	@OneToOne
	@JoinColumn(name="fk_pessoa")
	private Pessoa pessoas;

	public Avaliacao() {
	}

	public Avaliacao(Integer id, String classificacao, String review) {
		this.id = id;
		this.classificacao = classificacao;
		this.review = review;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public Integer getId() {
		return id;
	}

	public String getClassificacao() {
		return classificacao;
	}

	@Override
	public String toString() {
		return "Avaliacao [id=" + id + ", classificacao=" + classificacao + ", review=" + review + "]";
	}
	
	
	
	
	
	
}