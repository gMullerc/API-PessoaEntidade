package br.com.magnasistemas.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.magnasistemas.api.enumerator.enumEscolaridade;
import br.com.magnasistemas.api.enumerator.enumSituacaoEscolar;
import br.com.magnasistemas.api.records.cidadao.DadosAtualizacaoCidadao;
import br.com.magnasistemas.api.records.cidadao.DadosCadastroCidadao;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cidadaos")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@NoArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Cidadao extends Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	protected enumSituacaoEscolar situacaoEscolar;
	protected enumEscolaridade escolaridade;
	@OneToOne(cascade = { CascadeType.ALL })
	protected Documento documentos;

	public Cidadao(DadosCadastroCidadao dados) {

		super(dados.pessoa());
		this.situacaoEscolar = dados.situacaoEscolar();
		this.escolaridade = dados.escolaridade();
		this.documentos = new Documento(dados.documentos());

	}

	public void atualizarDadosCidadao(DadosAtualizacaoCidadao dados) {
		atualizarInformacoes(dados.pessoa());
		this.situacaoEscolar = dados.situacaoEscolar();
		this.escolaridade = dados.escolaridade();
	}
}
