package br.com.example.avaliacao.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.com.example.avaliacao.security.entities.Filme;
import br.com.example.avaliacao.security.entities.Pessoa;

@Repository
public interface FilmeRepository extends JpaRepository<Pessoa, Integer>   {

	@Query(value = "select * from clinica where nome = :nome;", nativeQuery = true)
    public Filme buscarFilme(String nome);
	
	void save(Filme newFilme);

}
