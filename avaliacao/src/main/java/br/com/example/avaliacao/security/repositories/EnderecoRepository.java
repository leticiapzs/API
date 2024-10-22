package br.com.example.avaliacao.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.example.avaliacao.security.entities.Endereco;

@Repository
	public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
	}
