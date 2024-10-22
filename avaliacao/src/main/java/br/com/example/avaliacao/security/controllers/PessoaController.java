package br.com.example.avaliacao.security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.example.avaliacao.security.dto.EnderecoRequestDTO;
import br.com.example.avaliacao.security.dto.EnderecoResponseDTO;
import br.com.example.avaliacao.security.dto.MessageResponseDTO;
import br.com.example.avaliacao.security.dto.PessoaDTO;
import br.com.example.avaliacao.security.entities.Pessoa;
import br.com.example.avaliacao.security.services.EmailService;
import br.com.example.avaliacao.security.services.EnderecoService;
import br.com.example.avaliacao.security.services.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
	
	@Autowired
	PessoaService pessoaService;
	
	@Autowired
	EnderecoService enderecoService;
	
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
	
	@PostMapping("/teste-cep")
    public EnderecoResponseDTO testeEndereco(@RequestBody EnderecoRequestDTO enderecoDto) {
        return enderecoService.consultarEndereco(enderecoDto);
    }
	
	@PostMapping("/cadastrar")
	public ResponseEntity<?> cadastrarPessoa(@RequestBody PessoaDTO pessoa) {
		pessoaService.cadastrarPessoa(pessoa);
		return ResponseEntity.ok(new MessageResponseDTO("Pessoa cadastrada com sucesso!"));
	}
}
