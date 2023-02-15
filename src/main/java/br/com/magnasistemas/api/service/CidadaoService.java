package br.com.magnasistemas.api.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.magnasistemas.api.exception.NotFoundExceptionHandler;
import br.com.magnasistemas.api.model.Cidadao;
import br.com.magnasistemas.api.records.cidadao.DadosAtualizacaoCidadao;
import br.com.magnasistemas.api.records.cidadao.DadosCadastroCidadao;
import br.com.magnasistemas.api.records.cidadao.DadosListagemCidadao;
import br.com.magnasistemas.api.repository.CidadaoRepository;

@Service
public class CidadaoService {

	private static final Logger LOG = Logger.getLogger(CidadaoService.class);

	@Autowired
	private CidadaoRepository repository;

	public Cidadao criarCidadao(DadosCadastroCidadao cid) {
		return repository.save(new Cidadao(cid));
	}

	public List<DadosListagemCidadao> listarCidadao() {

		List<DadosListagemCidadao> get = repository.findAll().stream().map(DadosListagemCidadao::new).toList();
		if (get.isEmpty()) {
			LOG.info("Não existem cidadões cadastrados na base de dados");
			throw new NotFoundExceptionHandler("Não foi possível localizar os dados, tente cadastrar algum cidadão");
		}
		LOG.info("Listando Dados de todos os Cidadãos");
		return get;
	}

	public List<DadosListagemCidadao> listarPorID(Long id) {
		List<DadosListagemCidadao> get = repository.findById(id).stream().map(DadosListagemCidadao::new).toList();
		if (get.isEmpty()) {
			LOG.info("Não existe esse ID cadastrado na base de dados");
			throw new NotFoundExceptionHandler("ID: %d não encontrado".formatted(id));
		}
		LOG.info("Listando o ID: %d".formatted(id));
		return get;

	}

	public Cidadao atualizarCidadao(DadosAtualizacaoCidadao dados) {
		Cidadao cidadao = repository.getReferenceById(dados.id());
		cidadao.atualizarDadosCidadao(dados);
		LOG.info("ID: %d, Atualizado".formatted(cidadao.getId()));

		return cidadao;
	}

	public String deletarCidadao(Long id) {

		repository.deleteById(id);
		LOG.info("ID: %d, DELETADO".formatted(id));

		return """
				O cidadao de ID: %d
				Foi deletado com sucesso.
				""".formatted(id);
	}
}
