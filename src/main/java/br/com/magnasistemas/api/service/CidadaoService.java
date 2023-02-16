package br.com.magnasistemas.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.magnasistemas.api.exception.BadRequestExceptionHandler;
import br.com.magnasistemas.api.exception.NotFoundExceptionHandler;
import br.com.magnasistemas.api.model.Cidadao;
import br.com.magnasistemas.api.records.cidadao.DadosAtualizacaoCidadao;
import br.com.magnasistemas.api.records.cidadao.DadosCadastroCidadao;
import br.com.magnasistemas.api.records.cidadao.DadosListagemCidadao;
import br.com.magnasistemas.api.repository.CidadaoRepository;

@Service
public class CidadaoService {


	@Autowired
	private CidadaoRepository repository;

	public Cidadao criarCidadao(DadosCadastroCidadao cid) {
		return repository.save(new Cidadao(cid));
	}

	public List<DadosListagemCidadao> listarCidadao() {
		List<DadosListagemCidadao> get = repository.findAll().stream().map(DadosListagemCidadao::new).toList();
		if (get.isEmpty())
			throw new NotFoundExceptionHandler("Não foi possível localizar os dados, tente cadastrar algum cidadão");
		return get;
	}

	public Cidadao listarPorID(Long id) {
		Optional<Cidadao> get = repository.findById(id);
		return get.orElseThrow(BadRequestExceptionHandler::new);
	}

	public Cidadao atualizarCidadao(DadosAtualizacaoCidadao dados) {
		Optional<Cidadao> cid = repository.findById(dados.id());
		if (cid.isEmpty())
			throw new BadRequestExceptionHandler();
		Cidadao cidadao = repository.getReferenceById(dados.id());	
		cidadao.atualizarDadosCidadao(dados);
		return cidadao;
	}

	public String deletarCidadao(Long id) {

		repository.deleteById(id);
		return """
				O cidadao de ID: %d
				Foi deletado com sucesso.
				""".formatted(id);
	}

	public Cidadao verificaExistencia(Long id) {
		Optional<Cidadao> cidadao = repository.findById(id);
		return cidadao.orElseThrow(BadRequestExceptionHandler::new);

	}
}
