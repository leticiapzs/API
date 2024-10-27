package br.com.example.avaliacao.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import br.com.example.avaliacao.security.dto.MessageResponseDTO;
import br.com.example.avaliacao.security.dto.PessoaDTO;
import br.com.example.avaliacao.security.dto.PessoaPutDTO;
import br.com.example.avaliacao.security.entities.Pessoa;
import br.com.example.avaliacao.security.repositories.PessoaRepository;
import jakarta.persistence.EntityNotFoundException;

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
	
	public ResponseEntity<?> atualizarPessoa(Integer id, PessoaPutDTO pessoaDTO) {
		Pessoa pessoa = pessoaRepository.findById(id).get();
		
		if (pessoaDTO.getId() != null) {
			pessoa.setId(pessoaDTO.getId());
		}
		if (pessoaDTO.getNomeCompleto() != null) {
			pessoa.setNomeCompleto(pessoaDTO.getNomeCompleto());
		}
		
		pessoaRepository.save(pessoa);
		
		return ResponseEntity.ok(new MessageResponseDTO("Pessoa atualizada com sucesso!"));
	}

	public void deletarPessoa(Integer id) {
		if (pessoaRepository.existsById(id)) {
			pessoaRepository.deleteById(id);
		} else {
			throw new EntityNotFoundException("Pessoa deletada!");
		}
	}
	
	
}
