API DESENVOLVIDA EM JAVA COM SPRING BOOT.

Para realizar requisições post em cidadão e profissional é usado.

/cidadao
{
	"pessoa": {
		"nome": "Guilherme",
		"dataDeNascimento": "2002-08-01",
		"etnia": "PARDO",
		"genero": "MASCULINO",
		"endereco": [
			{
				"logradouro": "CIPOLANDIA",
				"bairro": "REGINA",
				"cep": "05736100",
				"numero": 3,
				"complemento": "B",
				"cidade": "São Paulo",
				"uf": "SP"
			},
			{
				"logradouro": "Chinigua",
				"bairro": "Inga",
				"cep": "05736100",
				"numero": 3,
				"complemento": "B",
				"cidade": "São Paulo",
				"uf": "SP"
			}
		],
		"contato": [
			{
				"celular": "(11) 96742-1298",
				"telefone": "(11) 94556-5233",
				"email": "guilherme.mcdoDDFa1dffd5@gmail.com"
			},
						{
				"celular": "(11) 96723-1298",
				"telefone": "(11) 9423-5233",
				"email": "guilherme.ffd5@gmail.com"
			}
		]
	},
	"situacaoEscolar": "CURSANDO",
	"escolaridade": "SUPERIOR",
	"documentos": {
		"certidaDeNascimento": "234452253",
		"rg": "2342323434344",
		"cpf": "234522332254"
	}
}
/profissional

{
	"cidadao": {
		"pessoa": {
			"nome": "Guilherme",
			"dataDeNascimento": "2002-08-01",
			"etnia": "PARDO",
			"genero": "MASCULINO",
			"endereco": [
				{
					"logradouro": "Chinigua",
					"bairro": "Inga",
					"cep": "05736100",
					"numero": 3,
					"complemento": "B",
					"cidade": "São Paulo",
					"uf": "SP"
				},
				{
					"logradouro": "Chinigua",
					"bairro": "Inga",
					"cep": "05736100",
					"numero": 3,
					"complemento": "B",
					"cidade": "São Paulo",
					"uf": "SP"
				},
				{
					"logradouro": "Chinigua",
					"bairro": "Inga",
					"cep": "05736100",
					"numero": 3,
					"complemento": "B",
					"cidade": "São Paulo",
					"uf": "SP"
				},
				{
					"logradouro": "Chinigua",
					"bairro": "Inga",
					"cep": "05736100",
					"numero": 3,
					"complemento": "B",
					"cidade": "São Paulo",
					"uf": "SP"
				}
			],
			"contato": [
			{
				"celular": "(11) 96742-3298",
				"telefone": "(11) 94556-5633",
				"email": "guilhermee.mcdoDDFa1dffd5@gmail.com"
			}
		]
		},
		"situacaoEscolar": "CURSANDO",
		"escolaridade": "SUPERIOR",
		"documentos": {
			"certidaDeNascimento": "234253",
			"rg": "234234344",
			"cpf": "23423324"
		}
	},
	"cargo": "DEV",
	"tipoDeProfissional": "CLT",
	"remuneracao": "23200",
	"documentosProfissionais": {
		"pis": "243434",
		"carteiraDeTrabalho": "22132321"
	}
}

