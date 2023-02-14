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

import br.com.magnasistemas.api.model.Cidadao;
import br.com.magnasistemas.api.records.cidadao.DadosAtualizacaoCidadao;
import br.com.magnasistemas.api.records.cidadao.DadosCadastroCidadao;
import br.com.magnasistemas.api.records.cidadao.DadosListagemCidadao;
import br.com.magnasistemas.api.repository.CidadaoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("cidadao")
public class CidadaoController {

	@Autowired
	private CidadaoRepository repository;

	@PostMapping
	@Transactional
	public ResponseEntity<Cidadao> Cadastrar(@RequestBody @Valid DadosCadastroCidadao dados) {
		var cid = repository.save(new Cidadao(dados));
		return ResponseEntity.ok(cid);
	}

	@GetMapping
	public ResponseEntity<List<DadosListagemCidadao>> Procurar() {
		var get = repository.findAll().stream().map(DadosListagemCidadao::new).toList();
		return ResponseEntity.ok(get);
	}

	@GetMapping("/{id}")
	public ResponseEntity<List<DadosListagemCidadao>> ProcurarPorId(@PathVariable Long id) {
		
		var get = repository.findById(id).stream().map(DadosListagemCidadao::new).toList();

		return ResponseEntity.ok(get);
	}

	@PutMapping
	@Transactional
	public ResponseEntity<Cidadao> atualiza(@RequestBody @Valid DadosAtualizacaoCidadao dados) {
		var cidadao = repository.getReferenceById(dados.id());
		cidadao.atualizarDadosCidadao(dados);
		return ResponseEntity.ok(cidadao);

	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<String> deletar(@PathVariable Long id) {
		repository.deleteById(id);
		return ResponseEntity.ok("""
				O cidadao de ID: %d
				Foi deletado com sucesso.
				""".formatted(id));
	}

}
