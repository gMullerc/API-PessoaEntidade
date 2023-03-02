package br.com.magnasistemas.api.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.magnasistemas.api.enumerator.enumEtnia;
import br.com.magnasistemas.api.enumerator.enumGenero;
import br.com.magnasistemas.api.records.endereco.DadosEndereco;
import br.com.magnasistemas.api.records.pessoa.DadosAtualizacaoPessoa;
import br.com.magnasistemas.api.records.pessoa.DadosCadastroPessoa;
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
import jakarta.persistence.OneToMany;
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
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "pessoa_id")
	@JsonIgnore
	protected List<Endereco> endereco = new ArrayList<>();
	
	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "contatos_id")
	protected Contato contato;

	public Pessoa(DadosCadastroPessoa dados) {
		this.nome = dados.nome();
		this.genero = dados.genero();
		this.etnia = dados.etnia();
		this.dataDeNascimento = dados.dataDeNascimento();
		for (DadosEndereco endereco : dados.endereco()) {
			this.endereco.add(new Endereco(endereco));
		}
		this.contato = new Contato(dados.contato());
	}

	public void atualizarInformacoes(DadosAtualizacaoPessoa dados) {
		this.nome = dados.nome();
		for (DadosEndereco endereco : dados.endereco()) {
			this.endereco.add(new Endereco(endereco));
		}
		contato.atualizaInformacoesContato(dados.contato());

	}

}