package br.com.magnasistemas.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.magnasistemas.api.pessoa.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
	Page<Pessoa> findAllByAtivoTrue(Pageable paginacao);
}