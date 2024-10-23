package br.com.example.avaliacao.security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.example.avaliacao.security.dto.EnderecoRequestDTO;
import br.com.example.avaliacao.security.dto.EnderecoResponseDTO;
import br.com.example.avaliacao.security.services.EnderecoService;

@RestController	
@RequestMapping("/endereco")
public class EnderecoController {

	@Autowired
	EnderecoService enderecoService;
	
	@PostMapping("/cadastro-de-endereco")
    public EnderecoResponseDTO testeEndereco(@RequestBody EnderecoRequestDTO enderecoDto) {
        return enderecoService.consultarEndereco(enderecoDto);
    }
	
	@GetMapping("/{id}")
	public EnderecoResponseDTO buscarEndereco(@PathVariable Integer id) {
		return enderecoService.buscarEndereco(id);
	}
}
