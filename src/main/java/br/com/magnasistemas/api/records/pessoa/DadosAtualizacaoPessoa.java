package br.com.magnasistemas.api.records.pessoa;

import br.com.magnasistemas.api.records.contato.DadosContato;
import br.com.magnasistemas.api.records.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPessoa(Long id, @NotNull @NotBlank String nome, @Valid DadosEndereco endereco,
		@Valid DadosContato contato) {
}
