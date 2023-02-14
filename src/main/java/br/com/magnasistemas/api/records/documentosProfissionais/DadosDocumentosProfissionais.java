package br.com.magnasistemas.api.records.documentosProfissionais;

import jakarta.validation.constraints.NotBlank;

public record DadosDocumentosProfissionais(@NotBlank String pis, @NotBlank String carteiraDeTrabalho) {

}
