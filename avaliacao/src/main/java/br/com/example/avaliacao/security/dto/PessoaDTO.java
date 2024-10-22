package br.com.example.avaliacao.security.dto;

public class PessoaDTO {

	private String nomeCompleto;
	private Integer id;
	
	
	public PessoaDTO() {
	}


	public PessoaDTO(String nomeCompleto, Integer id) {
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


	@Override
	public String toString() {
		return "PessoaRequestDTO [nomeCompleto=" + nomeCompleto + ", id=" + id + "]";
	}
	
	
	
	
	
}
