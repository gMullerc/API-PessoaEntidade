package br.com.magnasistemas.api.model;

import java.math.BigDecimal;

import br.com.magnasistemas.api.enumerator.enumTipoDeProfissional;
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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "profissionais")
@Getter
@Setter
@NoArgsConstructor
public class Profissional extends Cidadao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	protected String cargo;
	@Enumerated(EnumType.STRING)
	protected enumTipoDeProfissional tipoDeProfissional;
	@OneToOne(cascade = { CascadeType.ALL })
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

}
