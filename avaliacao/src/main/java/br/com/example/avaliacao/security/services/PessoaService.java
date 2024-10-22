package br.com.example.avaliacao.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.example.avaliacao.security.dto.PessoaRequestDTO;
import br.com.example.avaliacao.security.repositories.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	PessoaRepository pessoaRepository;

	public void cadastrarPessoa(PessoaRequestDTO pessoa) {
	}
	
	

}
