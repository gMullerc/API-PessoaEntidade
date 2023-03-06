package br.com.magnasistemas.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.magnasistemas.api.records.contato.DadosContato;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "contatos")
@Entity(name = "Contato")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long contatos_id;
	private String celular;
	private String telefone;
	private String email;
	@ManyToOne
	@JoinColumn(name = "pessoa_id", insertable = false, updatable = false)
	@JsonIgnore
	private Pessoa pessoas_id;

	public Contato(DadosContato dadosContato) {
		this.celular = dadosContato.celular();
		this.telefone = dadosContato.telefone();
		this.email = dadosContato.email();
	}

}
