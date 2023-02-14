package br.com.magnasistemas.api.model;

import br.com.magnasistemas.api.records.documentosProfissionais.DadosDocumentosProfissionais;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "documentos_profissionais")
@Getter
@NoArgsConstructor
public class DocumentosProfissionais {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String pis;
	private String carteiraDeTrabalho;

	public DocumentosProfissionais(DadosDocumentosProfissionais dados) {
		this.pis = dados.pis();
		this.carteiraDeTrabalho = dados.carteiraDeTrabalho();
	}

}
