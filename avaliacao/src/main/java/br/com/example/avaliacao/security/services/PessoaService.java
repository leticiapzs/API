package br.com.example.avaliacao.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.example.avaliacao.security.dto.PessoaDTO;
import br.com.example.avaliacao.security.entities.Pessoa;
import br.com.example.avaliacao.security.repositories.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	PessoaRepository pessoaRepository;

	public void cadastrarPessoa(PessoaDTO pessoa) {
		Pessoa newPessoa = new Pessoa();
		newPessoa.setNomeCompleto(pessoa.getNomeCompleto());
		newPessoa.setId(pessoa.getId());
		
		pessoaRepository.save(newPessoa);
	}
	
	

}
