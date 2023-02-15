package br.com.magnasistemas.api.model;

import br.com.magnasistemas.api.records.endereco.DadosEndereco;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "enderecos")
@Entity(name = "Endereco")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String logradouro;
	private String bairro;
	private String cep;
	private String numero;
	private String complemento;
	private String cidade;
	private String uf;

	public Endereco(DadosEndereco endereco) {
		this.logradouro = endereco.logradouro();
		this.bairro = endereco.bairro();
		this.cep = endereco.cep();
		this.numero = endereco.numero();
		this.complemento = endereco.complemento();
		this.cidade = endereco.cidade();
		this.uf = endereco.uf();
	}

	public void atualizaInformacoesEndereco(DadosEndereco dados) {

			this.logradouro = dados.logradouro();
			this.bairro = dados.bairro();
			this.cep = dados.cep();
			this.numero = dados.numero();
			this.complemento = dados.complemento();
			this.cidade = dados.cidade();
			this.uf = dados.uf();
	}

}
