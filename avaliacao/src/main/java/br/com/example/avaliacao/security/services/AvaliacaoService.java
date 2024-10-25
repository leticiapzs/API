package br.com.example.avaliacao.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.example.avaliacao.security.dto.AvaliacaoDTO;
import br.com.example.avaliacao.security.entities.Avaliacao;
import br.com.example.avaliacao.security.repositories.AvaliacaoRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class AvaliacaoService {
	
	@Autowired
	AvaliacaoRepository avaliacaoRepository;
	
	public void criarAvaliacao(AvaliacaoDTO avaliacao) {
		Avaliacao newAvaliacao = new Avaliacao();
		newAvaliacao.setClassificacao(avaliacao.getClassificacao());
		newAvaliacao.setReview(avaliacao.getReview());
		
		avaliacaoRepository.save(newAvaliacao);
	}
	
	public void deletarAvaliacao(Integer id) {
		if (avaliacaoRepository.existsById(id)) {
			avaliacaoRepository.deleteById(id);
		} else {
			throw new EntityNotFoundException("Avaliação deletada com sucesso!");
		}
	}

}
