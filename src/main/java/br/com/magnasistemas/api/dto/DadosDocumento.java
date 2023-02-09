package br.com.magnasistemas.api.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosDocumento(@NotBlank String certidaDeNascimento, @NotBlank String cpf, @NotBlank String rg) {

}
