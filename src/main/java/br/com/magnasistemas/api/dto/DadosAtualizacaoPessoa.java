package br.com.magnasistemas.api.dto;

import jakarta.validation.Valid;

public record DadosAtualizacaoPessoa(Long id, String nome, @Valid DadosEndereco endereco, @Valid DadosContato contato){}
