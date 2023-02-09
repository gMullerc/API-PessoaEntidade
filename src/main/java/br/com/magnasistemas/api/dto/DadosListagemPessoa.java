package br.com.magnasistemas.api.dto;

import br.com.magnasistemas.api.enumerator.enumGenero;
import br.com.magnasistemas.api.model.Endereco;
import br.com.magnasistemas.api.model.Pessoa;

public record DadosListagemPessoa(Long id, String nome, enumGenero genero, Endereco endereco ) {

    public DadosListagemPessoa(Pessoa pessoa){
        this(pessoa.getId(), pessoa.getNome(), pessoa.getGenero(), pessoa.getEndereco());
    }
}
