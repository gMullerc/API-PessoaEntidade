API DESENVOLVIDA EM JAVA COM SPRING BOOT.

Para realizar requisições post em cidadão e profissional é usado.

/cidadao
{
	"pessoa": {
		"nome": ,
		"dataDeNascimento": ,
		"etnia": ,
		"genero": ,
		"endereco": {
			"logradouro": ,
			"bairro": ,
			"cep": ,
			"numero": ,
			"complemento": ,
			"cidade": ,
			"uf": 
		},
		"contato": {
			"celular": ,
			"telefone": ,
			"email": 
		}
	},
	"situacaoEscolar": ,
	"escolaridade": ,
	"documentos": {
		"certidaDeNascimento": ,
		"rg": ,
		"cpf": 
	}
}
/profissional

{
	"cidadao": {
		"pessoa": {
			"nome": ,
			"dataDeNascimento": ",
			"etnia": ,
			"genero": ,
			"endereco": {
				"logradouro": ,
				"bairro": ,
				"cep": ",
				"numero": ,
				"complemento": ,
				"cidade": ,
				"uf": 
			},
			"contato": {
				"celular": ,
				"telefone": ,
				"email": 
			}
		},
		"situacaoEscolar": ,
		"escolaridade": ,
		"documentos": {
			"certidaDeNascimento": ,
			"rg": ,
			"cpf": 
		}
	},
	"cargo": ,
	"tipoDeProfissional": ,
	"remuneracao": ,
	"documentosProfissionais": {
		"pis": ,
		"carteiraDeTrabalho": 
	}
}

