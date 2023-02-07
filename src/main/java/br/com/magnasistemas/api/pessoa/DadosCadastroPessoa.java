package br.com.magnasistemas.api.pessoa;

import br.com.magnasistemas.api.endereco.DadosEndereco;
import br.com.magnasistemas.api.enumerator.enumGenero;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.aspectj.weaver.ast.Not;




public record DadosCadastroPessoa(

        @NotBlank
        String nome,
        @NotNull @Valid
        DadosEndereco endereco,
        @NotNull
        enumGenero genero

) {
}
