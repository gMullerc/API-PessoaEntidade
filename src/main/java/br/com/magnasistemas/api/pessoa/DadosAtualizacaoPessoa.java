package br.com.magnasistemas.api.pessoa;

import br.com.magnasistemas.api.endereco.DadosEndereco;
import jakarta.validation.Valid;

public record DadosAtualizacaoPessoa(

        Long id,
        String nome,
        @Valid DadosEndereco endereco

        ){}
