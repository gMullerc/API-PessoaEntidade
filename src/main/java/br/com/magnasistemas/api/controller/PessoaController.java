package br.com.magnasistemas.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.magnasistemas.api.dto.DadosAtualizacaoPessoa;
import br.com.magnasistemas.api.dto.DadosCadastroPessoa;
import br.com.magnasistemas.api.dto.DadosListagemPessoa;
import br.com.magnasistemas.api.model.Pessoa;
import br.com.magnasistemas.api.repository.PessoaRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("pessoa")
public class PessoaController {

	@Autowired
	private PessoaRepository repository;

	@PostMapping
	@Transactional
	public Pessoa cadastro(@RequestBody @Valid DadosCadastroPessoa dados) {
		return repository.save(new Pessoa(dados));
	}

	@GetMapping
	public Page<DadosListagemPessoa> listar(Pageable pageable) {
		return repository.findAllByAtivoTrue(pageable).map(DadosListagemPessoa::new);
	}

	@GetMapping("/{id}")
	public Optional<Pessoa> listarPorId(@PathVariable Long id) {
		return repository.findById(id);
	}

	@PutMapping
	@Transactional
	public void atualiza(@RequestBody @Valid DadosAtualizacaoPessoa dados) {
		var pessoa = repository.getReferenceById(dados.id());
		pessoa.atualizarInformacoes(dados);

	}

	@DeleteMapping("/{id}")
	@Transactional
	public void deletar(@PathVariable Long id) {
		var pessoa = repository.getReferenceById(id);
		pessoa.inativar();
	}
}
