package br.com.magnasistemas.api.dto;

import br.com.magnasistemas.api.enumerator.enumEscolaridade;
import br.com.magnasistemas.api.enumerator.enumSituacaoEscolar;

public record DadosAtualizaCidadao(Long id, DadosAtualizacaoPessoa pessoa, enumEscolaridade escolaridade,
		enumSituacaoEscolar situacaoEscolar) {

}
