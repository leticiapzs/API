package br.com.example.avaliacao.security.dto;

public class PessoaPutDTO {
	
	private String nomeCompleto;
	private Integer id;
	
	
	
	public PessoaPutDTO() {
	}
	
	
	public PessoaPutDTO(String nomeCompleto, Integer id) {
		this.nomeCompleto = nomeCompleto;
		this.id = id;
	}


	public String getNomeCompleto() {
		return nomeCompleto;
	}


	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}
}
