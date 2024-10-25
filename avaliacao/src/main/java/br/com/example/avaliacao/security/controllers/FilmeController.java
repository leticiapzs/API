package br.com.example.avaliacao.security.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.example.avaliacao.security.dto.FilmeDTO;
import br.com.example.avaliacao.security.dto.FilmePutDTO;
import br.com.example.avaliacao.security.dto.MessageResponseDTO;
import br.com.example.avaliacao.security.entities.Filme;
import br.com.example.avaliacao.security.services.EmailService;
import br.com.example.avaliacao.security.services.FilmeService;
import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

	@Autowired
	EmailService emailService;
	
	@Autowired
	FilmeService filmeService;
	
	@PostMapping("/cadastrar")
	public ResponseEntity<?> cadastrarFilme(@RequestBody FilmeDTO filme) {
		filmeService.cadastrarFilme(filme);
		return ResponseEntity.ok(new MessageResponseDTO("Filme cadastrado com sucesso!"));
	}
	
	@GetMapping("/listar")
	public List<Filme> listarFilme() {
		return filmeService.listarFilme();
	}
	
	
	@DeleteMapping("/deletar")
	public ResponseEntity<String> deletarFilme(@PathVariable Integer id) {
		try {
			filmeService.deletarFilme(id);
			return ResponseEntity.noContent().build();
		} catch (EntityNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<?> atualizarFilme(@PathVariable Integer id, @RequestBody FilmePutDTO filmeDTO) {
		return filmeService.atualizarFilme(id, filmeDTO);
	}
}
