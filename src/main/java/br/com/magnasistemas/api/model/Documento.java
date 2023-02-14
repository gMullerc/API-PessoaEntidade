package br.com.magnasistemas.api.model;

import br.com.magnasistemas.api.records.documentos.DadosDocumento;
import jakarta.persistence.Entity;
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

	private String certidaDeNascimento;
	private String rg;
	@Id
	private String cpf;

}
