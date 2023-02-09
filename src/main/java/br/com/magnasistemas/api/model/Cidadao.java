package br.com.magnasistemas.api.model;

import br.com.magnasistemas.api.dto.DadosAtualizaCidadao;
import br.com.magnasistemas.api.dto.DadosCadastroCidadao;
import br.com.magnasistemas.api.enumerator.enumEscolaridade;
import br.com.magnasistemas.api.enumerator.enumSituacaoEscolar;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cidadaos")
@Getter
@NoArgsConstructor
public class Cidadao extends Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	protected enumSituacaoEscolar situacaoEscolar;
	protected enumEscolaridade escolaridade;
	@OneToOne(cascade = { CascadeType.ALL })
	protected Documento documentos;

	
	public Cidadao(DadosCadastroCidadao dados) {

		this.nome = dados.pessoa().nome();
		this.genero = dados.pessoa().genero();
		this.etnia = dados.pessoa().etnia();
		this.ativo = true;
		this.dataDeNascimento = dados.pessoa().dataDeNascimento();
		this.endereco = new Endereco(dados.pessoa().endereco());
		this.contato = new Contato(dados.pessoa().contato());
		this.situacaoEscolar = dados.situacaoEscolar();
		this.escolaridade = dados.escolaridade();
		this.documentos = new Documento(dados.documentos());
		

	}

	
	public void atualizarDadosCidadao(DadosAtualizaCidadao dados) {
		atualizarInformacoes(dados.pessoa());
		this.situacaoEscolar = dados.situacaoEscolar();
		this.escolaridade = dados.escolaridade();
	}
}
