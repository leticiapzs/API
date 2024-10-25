package br.com.example.avaliacao.security.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	
	@ManyToOne
	@JoinColumn(name="fk_user")
	private User user;

	public Avaliacao() {
	}

	public Avaliacao(Integer id, String classificacao, String review, Pessoa pessoas, User user) {
		this.id = id;
		this.classificacao = classificacao;
		this.review = review;
		this.pessoas = pessoas;
		this.user = user;
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public Pessoa getPessoas() {
		return pessoas;
	}

	public void setPessoas(Pessoa pessoas) {
		this.pessoas = pessoas;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Avaliacao [id=" + id + ", classificacao=" + classificacao + ", review=" + review + ", pessoas="
				+ pessoas + ", user=" + user + "]";
	}

	
	
	
}