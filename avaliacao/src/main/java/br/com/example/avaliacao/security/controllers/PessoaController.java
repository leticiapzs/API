package br.com.example.avaliacao.security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.example.avaliacao.security.services.EmailService;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
	
	@Autowired
	EmailService emailService;
	
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
