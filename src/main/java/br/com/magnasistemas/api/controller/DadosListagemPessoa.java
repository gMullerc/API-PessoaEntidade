package br.com.magnasistemas.api.controller;

import br.com.magnasistemas.api.endereco.Endereco;
import br.com.magnasistemas.api.enumerator.enumGenero;
import br.com.magnasistemas.api.pessoa.Pessoa;

public record DadosListagemPessoa(Long id, String nome, enumGenero genero, Endereco endereco ) {

    public DadosListagemPessoa(Pessoa pessoa){
        this(pessoa.getId(), pessoa.getNome(), pessoa.getGenero(), pessoa.getEndereco());
    }
}
