package br.com.magnasistemas.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.magnasistemas.api.dto.DadosAtualizaCidadao;
import br.com.magnasistemas.api.dto.DadosCadastroCidadao;
import br.com.magnasistemas.api.model.Cidadao;
import br.com.magnasistemas.api.repository.CidadaoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("cidadao")
public class CidadaoController {

	@Autowired
	private CidadaoRepository repository;

	@PostMapping
	@Transactional
	public Cidadao Cadastrar(@RequestBody @Valid DadosCadastroCidadao dados) {
		return repository.save(new Cidadao(dados));
	}

	@GetMapping
	public ResponseEntity<List<Cidadao>> Procurar() {
		List<Cidadao> get = repository.findAll();
		return ResponseEntity.ok(get);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Cidadao>> ProcurarPorId(@PathVariable Long id) {
		
		Optional<Cidadao> get = repository.findById(id);
		return ResponseEntity.ok(get);
	}

	@PutMapping
	@Transactional
	public void atualiza(@RequestBody @Valid DadosAtualizaCidadao dados) {
		Cidadao cidadao = repository.getReferenceById(dados.id());
		cidadao.atualizarDadosCidadao(dados);

	}

	@DeleteMapping("/{id}")
	@Transactional
	public void deletar(@PathVariable Long id) {
		repository.deleteById(id);
	}

}
