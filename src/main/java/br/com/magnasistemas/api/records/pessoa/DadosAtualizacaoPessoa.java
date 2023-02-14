package br.com.magnasistemas.api.records.pessoa;

import br.com.magnasistemas.api.records.contato.DadosContato;
import br.com.magnasistemas.api.records.endereco.DadosEndereco;
import jakarta.validation.Valid;

public record DadosAtualizacaoPessoa(Long id, String nome, @Valid DadosEndereco endereco, @Valid DadosContato contato){}
