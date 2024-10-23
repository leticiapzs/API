package br.com.example.avaliacao.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.example.avaliacao.security.dto.FilmeDTO;
import br.com.example.avaliacao.security.entities.Filme;
import br.com.example.avaliacao.security.repositories.FilmeRepository;

@Service
public class FilmeService {
	
	@Autowired
	FilmeRepository filmeRepository;

	public void cadastrarFilme(FilmeDTO filme) {
		Filme newFilme = new Filme();
		newFilme.setAnoDeLancamento(filme.getAnoDeLancamento());
		newFilme.setGenero(filme.getGenero());
		newFilme.setNomeFilme(filme.getNomeFilme());	
				
		filmeRepository.save(newFilme);
	}
	
}
