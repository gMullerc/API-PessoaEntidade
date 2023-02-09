package br.com.magnasistemas.api.dto;

import br.com.magnasistemas.api.enumerator.enumEscolaridade;
import br.com.magnasistemas.api.enumerator.enumSituacaoEscolar;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroCidadao(
		
		//this.dataDeNascimento = dados.pessoa().dataDeNascimento();
		
		@NotNull DadosCadastroPessoa pessoa, 
		@NotNull enumSituacaoEscolar situacaoEscolar,
		@NotNull enumEscolaridade escolaridade, 
		@NotNull @Valid DadosDocumento documentos
)

{

}