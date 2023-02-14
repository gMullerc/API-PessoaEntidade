package br.com.magnasistemas.api.records.cidadao;

import br.com.magnasistemas.api.enumerator.enumEscolaridade;
import br.com.magnasistemas.api.enumerator.enumSituacaoEscolar;
import br.com.magnasistemas.api.records.pessoa.DadosAtualizacaoPessoa;

public record DadosAtualizacaoCidadao(Long id, DadosAtualizacaoPessoa pessoa, enumEscolaridade escolaridade,
		enumSituacaoEscolar situacaoEscolar) {

}
