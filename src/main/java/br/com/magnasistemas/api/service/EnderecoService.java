package br.com.magnasistemas.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.magnasistemas.api.exception.NotFoundExceptionHandler;
import br.com.magnasistemas.api.model.Endereco;
import br.com.magnasistemas.api.model.Pessoa;
import br.com.magnasistemas.api.records.endereco.DadosAtualizaEndereco;
import br.com.magnasistemas.api.records.pessoa.DadosAtualizacaoPessoa;
import br.com.magnasistemas.api.repository.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository repo;

	public List<Endereco> atualizarEndereco(DadosAtualizacaoPessoa dados, Pessoa pessoa) {

		List<Endereco> end = pessoa.getEndereco();
		List<DadosAtualizaEndereco> dadosEndereco = dados.endereco();

		for (DadosAtualizaEndereco dadosend : dadosEndereco) {

			Endereco ref = repo.getReferenceById(dadosend.enderecos_id());

			if (!end.contains(ref)) {
				throw new NotFoundExceptionHandler("Não foi possível localizar esse endereço em seu nome");
			}

			ref.setBairro(dadosend.bairro());
			ref.setCep(dadosend.cep());
			ref.setCidade(dadosend.cidade());
			ref.setComplemento(dadosend.complemento());
			ref.setNumero(dadosend.numero());
			ref.setLogradouro(dadosend.logradouro());
			end.add(ref);
		}
		return end;
	}

}
