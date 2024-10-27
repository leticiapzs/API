package br.com.example.avaliacao.security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.example.avaliacao.security.dto.MessageResponseDTO;
import br.com.example.avaliacao.security.dto.PessoaDTO;
import br.com.example.avaliacao.security.dto.PessoaPutDTO;
import br.com.example.avaliacao.security.services.EnderecoService;
import br.com.example.avaliacao.security.services.PessoaService;
import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
	
	@Autowired
	PessoaService pessoaService;
	
	@Autowired
	EnderecoService enderecoService;

	
	@PostMapping("/cadastrar")
	public ResponseEntity<?> cadastrarPessoa(@RequestBody PessoaDTO pessoa) {
		pessoaService.cadastrarPessoa(pessoa);
		return ResponseEntity.ok(new MessageResponseDTO("Pessoa cadastrada com sucesso!"));
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<?> atualizarPessoa(@PathVariable Integer id, @RequestBody PessoaPutDTO pessoaDTO) {
		return pessoaService.atualizarPessoa(id, pessoaDTO);
	}
	
	@DeleteMapping("/deletar")
	public ResponseEntity<String> deletarPessoa(@PathVariable Integer id) {
		try {
			pessoaService.deletarPessoa(id);
			return ResponseEntity.noContent().build();
		} catch (EntityNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	
}

