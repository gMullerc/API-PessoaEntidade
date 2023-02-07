package br.com.magnasistemas.api.pessoa;

import br.com.magnasistemas.api.endereco.Endereco;
import br.com.magnasistemas.api.enumerator.enumGenero;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Table(name = "pessoas")
@Entity(name = "Pessoa")
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected String nome;
    
    
    @Embedded
    protected Endereco endereco;
    
    @Enumerated(EnumType.STRING)
    protected enumGenero genero;
    protected Boolean ativo;


    public Pessoa(DadosCadastroPessoa dados) {
        this.nome = dados.nome();
        this.genero = dados.genero();
        this.ativo = true;
        this.endereco = new Endereco(dados.endereco());
    }

    

    
    public void atualizarInformacoes(DadosAtualizacaoPessoa dados) {

        if (dados.nome() != null){
            this.nome = dados.nome();
        }
        if (dados.endereco() != null){
            endereco.atualizaInformacoes(dados.endereco());
        }

    }
    
    


    public void inativar() {
        this.ativo = false;
    }
}