package br.com.magnasistemas.api.model;

import br.com.magnasistemas.api.records.documentos.DadosDocumento;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "documentos")
@Entity(name = "Documentos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Documento {

	public Documento(DadosDocumento documento) {
		this.certidaDeNascimento = documento.certidaDeNascimento();
		this.cpf = documento.cpf();
		this.rg = documento.rg();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long documentos_id;
	@Column(unique = true)
	private String certidaDeNascimento;
	@Column(unique = true)
	private String rg;
	@Column(unique = true)
	private String cpf;

}
