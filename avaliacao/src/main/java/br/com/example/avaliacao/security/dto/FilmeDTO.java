package br.com.example.avaliacao.security.dto;



public class FilmeDTO {

	private Integer id;
	private Integer anoDeLancamento;
	private String genero;
	private String nomeFilme;
	
	
	public FilmeDTO() {
	}


	public FilmeDTO(Integer id, Integer anoDeLancamento, String genero, String nomeFilme) {
		this.id = id;
		this.anoDeLancamento = anoDeLancamento;
		this.genero = genero;
		this.nomeFilme = nomeFilme;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getAnoDeLancamento() {
		return anoDeLancamento;
	}


	public void setAnoDeLancamento(Integer anoDeLancamento) {
		this.anoDeLancamento = anoDeLancamento;
	}


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}


	public String getNomeFilme() {
		return nomeFilme;
	}


	public void setNomeFilme(String nomeFilme) {
		this.nomeFilme = nomeFilme;
	}


	@Override
	public String toString() {
		return "FilmeDTO [id=" + id + ", anoDeLancamento=" + anoDeLancamento + ", genero=" + genero + ", nomeFilme="
				+ nomeFilme + "]";
	}	
}



