package br.com.magnasistemas.api.model;

import java.time.LocalDate;

import br.com.magnasistemas.api.dto.DadosAtualizacaoPessoa;
import br.com.magnasistemas.api.dto.DadosCadastroPessoa;
import br.com.magnasistemas.api.enumerator.enumEtnia;
import br.com.magnasistemas.api.enumerator.enumGenero;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "pessoas")
@Entity(name = "Pessoa")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pessoa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	protected String nome;
	protected LocalDate dataDeNascimento;
	protected enumEtnia etnia;
	@Enumerated(EnumType.STRING)
	protected enumGenero genero;
	@OneToOne(cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "endereco_id")
	protected Endereco endereco;
	@OneToOne(cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "contato_id")
	protected Contato contato;
	protected Boolean ativo;

	public Pessoa(DadosCadastroPessoa dados) {
		this.nome = dados.nome();
		this.genero = dados.genero();
		this.etnia = dados.etnia();
		this.dataDeNascimento = dados.dataDeNascimento();
		this.endereco = new Endereco(dados.endereco());
		this.contato = new Contato(dados.contato());
		this.ativo = true;
	}

	public void atualizarInformacoes(DadosAtualizacaoPessoa dados) {

		if (dados.nome() != null) {
			this.nome = dados.nome();
		}
		if (dados.endereco() != null) {
			endereco.atualizaInformacoesEndereco(dados.endereco());
		}
		if (dados.contato() != null) {
			contato.atualizaInformacoesContato(dados.contato());
		}

	}

	public void inativar() {
		this.ativo = false;
	}
}