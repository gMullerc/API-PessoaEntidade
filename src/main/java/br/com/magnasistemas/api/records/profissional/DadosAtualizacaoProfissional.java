package br.com.magnasistemas.api.records.profissional;

import java.math.BigDecimal;

import br.com.magnasistemas.api.enumerator.enumTipoDeProfissional;
import br.com.magnasistemas.api.model.DocumentosProfissionais;
import br.com.magnasistemas.api.records.cidadao.DadosAtualizacaoCidadao;

public record DadosAtualizacaoProfissional(Long id, DadosAtualizacaoCidadao cidadao, String cargo,
		enumTipoDeProfissional escolaridade, BigDecimal remuneracao, DocumentosProfissionais documentosProfissionais) {

}
