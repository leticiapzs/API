package br.com.example.avaliacao.security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.example.avaliacao.security.dto.AvaliacaoDTO;
import br.com.example.avaliacao.security.dto.MessageResponseDTO;
import br.com.example.avaliacao.security.services.AvaliacaoService;

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
	
}
