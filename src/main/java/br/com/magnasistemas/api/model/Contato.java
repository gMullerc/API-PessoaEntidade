package br.com.magnasistemas.api.model;

import br.com.magnasistemas.api.records.contato.DadosContato;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "contatos")
@Entity(name = "Contato")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Contato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String celular;
	private String telefone;
	private String email;



	public Contato(DadosContato dadosContato) {

		this.celular = dadosContato.celular();
		this.telefone = dadosContato.telefone();
		this.email = dadosContato.email();

	}



	public void atualizaInformacoesContato(DadosContato contato) {
		
		if(contato.celular() != null) {
			this.celular = contato.celular();
		}
		if(contato.email() != null) {
			this.email = contato.email();
		}
		if(contato.telefone() != null) {
			this.telefone = contato.telefone();
		}
		
	}

}
