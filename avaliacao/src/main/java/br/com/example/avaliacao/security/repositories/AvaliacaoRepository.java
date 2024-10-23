package br.com.example.avaliacao.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.example.avaliacao.security.entities.Avaliacao;


@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Integer> {
	
}
