package br.com.magnasistemas.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.magnasistemas.api.exception.BadRequestExceptionHandler;
import br.com.magnasistemas.api.exception.NotFoundExceptionHandler;
import br.com.magnasistemas.api.model.Profissional;
import br.com.magnasistemas.api.records.profissional.DadosAtualizacaoProfissional;
import br.com.magnasistemas.api.records.profissional.DadosCadastroProfissional;
import br.com.magnasistemas.api.records.profissional.DadosListagemProfissional;
import br.com.magnasistemas.api.repository.ProfissionalRepository;

@Service
public class ProfissionalService {

	@Autowired
	private ProfissionalRepository repository;

	public Profissional criaProfissional(DadosCadastroProfissional prof) {
		return repository.save(new Profissional(prof));
	}

	public List<DadosListagemProfissional> listarProfissional() {
		List<DadosListagemProfissional> get = repository.findAll().stream().map(DadosListagemProfissional::new)
				.toList();
		if (get.isEmpty())
			throw new NotFoundExceptionHandler("Não foi possível localizar os dados, tente cadastrar algum cidadão");
		return get;
	}

	public Profissional listarPorID(Long id) {
		Optional<Profissional> get = repository.findById(id);
		return get.orElseThrow(BadRequestExceptionHandler::new);
	}

	public Profissional atualizarProfissional(DadosAtualizacaoProfissional dados) {
		Optional<Profissional> prof = repository.findById(dados.id());
		if (prof.isEmpty())
			throw new BadRequestExceptionHandler();
		Profissional profissional = repository.getReferenceById(dados.id());
		profissional.atualizarDadosProfissionais(dados);
		return profissional;
	}

	public String deletarProfissional(Long id) {

		repository.deleteById(id);
		return """
				O profissional de ID: %d
				Foi deletado com sucesso.
				""".formatted(id);
	}

	public Profissional verificaExistencia(Long id) {
		Optional<Profissional> profissional = repository.findById(id);
		return profissional.orElseThrow(BadRequestExceptionHandler::new);

	}
}
