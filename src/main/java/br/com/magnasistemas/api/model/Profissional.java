package br.com.magnasistemas.api.model;

import java.math.BigDecimal;

import br.com.magnasistemas.api.enumerator.enumEscolaridade;
import br.com.magnasistemas.api.enumerator.enumSituacaoEscolar;
import br.com.magnasistemas.api.enumerator.enumTipoDeProfissional;
import br.com.magnasistemas.api.records.cidadao.DadosAtualizacaoCidadao;
import br.com.magnasistemas.api.records.cidadao.DadosCadastroCidadao;
import br.com.magnasistemas.api.records.pessoa.DadosAtualizacaoPessoa;
import br.com.magnasistemas.api.records.profissional.DadosAtualizacaoProfissional;
import br.com.magnasistemas.api.records.profissional.DadosCadastroProfissional;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "profissionais")
@Getter
@NoArgsConstructor
public class Profissional extends Cidadao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	protected String cargo;
	@Enumerated(EnumType.STRING)
	protected enumTipoDeProfissional tipoDeProfissional;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "documentos_profissionais_id")
	protected DocumentosProfissionais documentosProfissionais;
	protected BigDecimal remuneracao;

	public Profissional(DadosCadastroProfissional dados) {
		super(dados.cidadao());
		this.cargo = dados.cargo();
		this.tipoDeProfissional = dados.tipoDeProfissional();
		this.remuneracao = dados.remuneracao();
		this.documentosProfissionais = new DocumentosProfissionais(dados.documentosProfissionais());

	}
	
	public void atualizarDadosProfissionais(DadosAtualizacaoProfissional dados) {
		
		atualizarDadosCidadao(dados.cidadao());
		this.cargo = dados.cargo();
		this.tipoDeProfissional = dados.tipoDeProfissional();
		this.remuneracao = dados.remuneracao();
	
		
	}

}
