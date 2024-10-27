package br.com.example.avaliacao.security.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import br.com.example.avaliacao.security.dto.FilmeDTO;
import br.com.example.avaliacao.security.dto.FilmePutDTO;
import br.com.example.avaliacao.security.dto.MessageResponseDTO;
import br.com.example.avaliacao.security.entities.Avaliacao;
import br.com.example.avaliacao.security.entities.Filme;
import br.com.example.avaliacao.security.entities.Pessoa;
import br.com.example.avaliacao.security.repositories.AvaliacaoRepository;
import br.com.example.avaliacao.security.repositories.FilmeRepository;
import br.com.example.avaliacao.security.repositories.PessoaRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class FilmeService {
	
	@Autowired
	FilmeRepository filmeRepository;
	
	@Autowired
	AvaliacaoRepository avaliacaoRepository;
	
	public void cadastrarFilme(FilmeDTO filme) {
		Filme newFilme = new Filme();
		newFilme.setAnoDeLancamento(filme.getAnoDeLancamento());
		newFilme.setGenero(filme.getGenero());
		newFilme.setNomeFilme(filme.getNomeFilme());	
		
		filmeRepository.save(newFilme);
	}
	
	public static FilmeDTO buscarFilme (Integer id) {
		return null;
	}

	public List<Filme> listarFilme() {
		return filmeRepository.findAll();
	}
	
	
	
	public ResponseEntity<?> atualizarFilme(Integer id, FilmePutDTO filmeDTO) {
		
		Filme filme = filmeRepository.findById(id).get();
		
		if (filmeDTO.getId() != null) {
			filme.setId(filmeDTO.getId());
		}
		if (filmeDTO.getNomeFilme() != null) {
			filme.setDescricao(filmeDTO.getNomeFilme());
		}
		
		filmeRepository.save(filme);
		
		return ResponseEntity.ok(new MessageResponseDTO("Filme atualizado com sucesso!"));
	}
	
	public void deletarFilme(Integer id) {
		if (filmeRepository.existsById(id)) {
			filmeRepository.deleteById(id);
		} else {
			throw new EntityNotFoundException("Filme deletado!");
		}
	}
}
