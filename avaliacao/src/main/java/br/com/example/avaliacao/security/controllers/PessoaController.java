package br.com.example.avaliacao.security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.example.avaliacao.security.dto.MessageResponseDTO;
import br.com.example.avaliacao.security.dto.PessoaDTO;
import br.com.example.avaliacao.security.services.EnderecoService;
import br.com.example.avaliacao.security.services.PessoaService;

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
}
