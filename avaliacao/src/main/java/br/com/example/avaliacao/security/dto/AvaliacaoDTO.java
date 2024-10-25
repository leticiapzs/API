package br.com.example.avaliacao.security.dto;


public class AvaliacaoDTO {
	private Integer id;
	private String classificacao;
	private String review;
	
	
	public AvaliacaoDTO() {
	}


	public AvaliacaoDTO(Integer id, String classificacao, String review) {
		this.id = id;
		this.classificacao = classificacao;
		this.review = review;
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


	@Override
	public String toString() {
		return "AvaliacaoDTO [id=" + id + ", classificacao=" + classificacao + ", review=" + review + "]";
	}
	
	
	


}
