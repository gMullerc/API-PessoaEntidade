package br.com.magnasistemas.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.magnasistemas.api.exception.BadRequestExceptionHandler;
import br.com.magnasistemas.api.exception.NotFoundExceptionHandler;
import br.com.magnasistemas.api.model.Cidadao;
import br.com.magnasistemas.api.model.Profissional;
import br.com.magnasistemas.api.records.cidadao.DadosListagemCidadao;
import br.com.magnasistemas.api.records.profissional.DadosAtualizacaoProfissional;
import br.com.magnasistemas.api.records.profissional.DadosCadastroProfissional;
import br.com.magnasistemas.api.records.profissional.DadosListagemProfissional;
import br.com.magnasistemas.api.repository.ProfissionalRepository;

@Service
public class ProfissionalService {

	@Autowired
	private ProfissionalRepository repository;

	@Autowired
	private ContatoService contatos;

	@Autowired
	private EnderecoService enderecos;

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

	public DadosListagemProfissional listarPorID(Long id) {
		Optional<DadosListagemProfissional> get = repository.findById(id).map(DadosListagemProfissional::new);
		
		return get.orElseThrow(BadRequestExceptionHandler::new);
	}

	public Profissional atualizarProfissional(DadosAtualizacaoProfissional dados) {
		Optional<Profissional> prof = repository.findById(dados.id());
		if (prof.isEmpty())
			throw new BadRequestExceptionHandler();
		Profissional profissional = repository.getReferenceById(dados.id());
		profissional.setNome(dados.cidadao().pessoa().nome());
		profissional.setEndereco(enderecos.atualizarEndereco(dados.cidadao().pessoa(), profissional));
		profissional.setContato(contatos.atualizarContato(dados.cidadao().pessoa(), profissional));
		profissional.setEscolaridade(dados.cidadao().escolaridade());
		profissional.setSituacaoEscolar(dados.cidadao().situacaoEscolar());
		profissional.setCargo(dados.cargo());
		profissional.setRemuneracao(dados.remuneracao());
		profissional.setTipoDeProfissional(dados.tipoDeProfissional());

		return repository.save(prof.get());

	}

	public void deletarProfissional(Long id) {
		Profissional prof = repository.findById(id).orElseThrow(BadRequestExceptionHandler::new);

		repository.deleteById(prof.getId());

	}

}
