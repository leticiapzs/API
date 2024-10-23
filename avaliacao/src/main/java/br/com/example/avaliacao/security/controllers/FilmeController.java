package br.com.example.avaliacao.security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.example.avaliacao.security.dto.FilmeDTO;
import br.com.example.avaliacao.security.dto.MessageResponseDTO;
import br.com.example.avaliacao.security.services.EmailService;
import br.com.example.avaliacao.security.services.FilmeService;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

	@Autowired
	EmailService emailService;
	
	@Autowired
	FilmeService filmeService;
	
	@PostMapping("/cadastrar")
	public ResponseEntity<?> cadastrarPessoa(@RequestBody FilmeDTO filme) {
		filmeService.cadastrarFilme(filme);
		return ResponseEntity.ok(new MessageResponseDTO("Filme cadastrado com sucesso!"));
	}
	
	@GetMapping
	public String  writerTeste() {
		emailService.writerTeste();
		return "Email enviado com sucesso!";
	}
	@GetMapping("/envioemail")
	public String writerTeste2() {
		emailService.writerTeste2();
		return "Email enviado com sucesso!";
	}
	@GetMapping("/Filmes")
    public String mailSend() {
        emailService.mailSend();
        return "Email(2) Enviado com Sucesso";
    }
	
}
