package br.com.magnasistemas.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.magnasistemas.api.model.Profissional;
import br.com.magnasistemas.api.records.profissional.DadosAtualizacaoProfissional;
import br.com.magnasistemas.api.records.profissional.DadosCadastroProfissional;
import br.com.magnasistemas.api.records.profissional.DadosListagemProfissional;
import br.com.magnasistemas.api.repository.ProfissionalRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("profissional")
public class ProfissionalController {
	@Autowired
	private ProfissionalRepository repository;

	@PostMapping
	@Transactional
	public ResponseEntity<Profissional> Cadastrar(@RequestBody @Valid DadosCadastroProfissional dados) {
		var cid = repository.save(new Profissional(dados));
		return ResponseEntity.ok(cid);
	}

	@GetMapping
	public ResponseEntity<List<DadosListagemProfissional>> Procurar() {

		var get = repository.findAll().stream().map(DadosListagemProfissional::new).toList();
		return ResponseEntity.ok(get);

	}

	@GetMapping("/{id}")
	public ResponseEntity<List<DadosListagemProfissional>> ProcurarPorId(@PathVariable Long id) {

		var get = repository.findById(id).stream().map(DadosListagemProfissional::new).toList();
		return ResponseEntity.ok(get);

	}
	
	@PutMapping
	public ResponseEntity<Profissional> Atualizar(@RequestBody @Valid DadosAtualizacaoProfissional dados){
		return null;
		
	}
	

}
