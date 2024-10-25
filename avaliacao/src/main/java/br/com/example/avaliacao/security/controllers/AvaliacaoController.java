package br.com.example.avaliacao.security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.example.avaliacao.security.dto.AvaliacaoDTO;
import br.com.example.avaliacao.security.dto.MessageResponseDTO;
import br.com.example.avaliacao.security.services.AvaliacaoService;
import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {

	@Autowired
	AvaliacaoService avaliacaoService;
	
	@PostMapping("/criar-avaliacao")
	public ResponseEntity<?> criarAvaliacao(@RequestBody AvaliacaoDTO avaliacao) {
		avaliacaoService.criarAvaliacao(avaliacao);
		return ResponseEntity.ok(new MessageResponseDTO("Avaliação criada com sucesso!"));
	}
	
	@DeleteMapping("/deletar-avaliacao")
	public ResponseEntity<String> deletarAvaliacao(@PathVariable Integer id) {
		try {
			avaliacaoService.deletarAvaliacao(id);
			return ResponseEntity.noContent().build();
		} catch (EntityNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	
}
