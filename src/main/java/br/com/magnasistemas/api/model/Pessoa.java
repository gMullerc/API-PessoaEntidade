package br.com.magnasistemas.api.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.magnasistemas.api.enumerator.enumEtnia;
import br.com.magnasistemas.api.enumerator.enumGenero;
import br.com.magnasistemas.api.records.contato.DadosContato;
import br.com.magnasistemas.api.records.endereco.DadosEndereco;
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
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "pessoas")
@Entity(name = "Pessoa")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
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

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "pessoa_id")
	@JsonIgnore
	protected List<Contato> contato = new ArrayList<>();

	public Pessoa(DadosCadastroPessoa dados) {
		this.nome = dados.nome();
		this.genero = dados.genero();
		this.etnia = dados.etnia();
		this.dataDeNascimento = dados.dataDeNascimento();
		for (DadosEndereco endereco : dados.endereco()) {
			this.endereco.add(new Endereco(endereco));
		}
		for (DadosContato contato : dados.contato()) {
			this.contato.add(new Contato(contato));
		}
	}

}