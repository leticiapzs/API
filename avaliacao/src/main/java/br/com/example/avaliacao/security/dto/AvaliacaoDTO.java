package br.com.example.avaliacao.security.dto;


public class AvaliacaoDTO {
	private String classificacao;
	private String review;
	
	public AvaliacaoDTO() {
	}

	public AvaliacaoDTO(String classificacao, String review) {
		this.classificacao = classificacao;
		this.review = review;
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
		return "AvaliacaoDTO [classificacao=" + classificacao + ", review=" + review + "]";
	} 
	
	
	
	
	

}
