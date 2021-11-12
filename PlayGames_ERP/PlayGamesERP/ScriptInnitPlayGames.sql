--H- APAGAR TABELSA PARA TESTES
DROP TABLE SALDO_CAIXA;
DROP TABLE MOVIMENTACAO_CAIXA;
DROP TABLE CONTAS_PAGAR;
DROP TABLE CONTAS_RECEBER;
DROP TABLE SITUACAO_CONTAS;
DROP TABLE ESTOQUE;
DROP TABLE ITEM_VENDA;
DROP TABLE VENDA;
DROP TABLE FORMA_PAGAMENTO;
DROP TABLE PRODUTO;
DROP TABLE CATEGORIA;
DROP TABLE CADASTRO;
DROP TABLE CIDADE;
DROP TABLE ESTADO;
DROP TABLE PAIS; 

--H- APGAAR GERADORES PARA TESTES
DROP GENERATOR G_PAIS;
DROP GENERATOR G_ESTADO;
DROP GENERATOR G_CIDADE;
DROP GENERATOR G_CADASTRO;
DROP GENERATOR G_CATEGORIA;
DROP GENERATOR G_PRODUTO;
DROP GENERATOR G_FORMA_PAGAMENTO;
DROP GENERATOR G_VENDA;
DROP GENERATOR G_ITEM_VENDA;
DROP GENERATOR G_ESTOQUE;
DROP GENERATOR G_SITUACAO_CONTAS;
DROP GENERATOR G_CONTAS_RECEBER;
DROP GENERATOR G_CONTAS_PAGAR;
DROP GENERATOR G_MOVIMENTACAO_CAIXA;
DROP GENERATOR G_SALDO_CAIXA;

--H- CRIAR AS TABELAS

CREATE TABLE PAIS (
	ID 			INTEGER		NOT NULL 	PRIMARY KEY,
	NOME		VARCHAR(30)	NOT NULL,
	SIGLA		CHAR(3)		NOT NULL,
	STATUS		BOOLEAN		NOT NULL
);
CREATE TABLE ESTADO ( 
	ID 			INTEGER		NOT NULL PRIMARY KEY,
	ID_PAIS		INTEGER		NOT NULL,
	NOME 		VARCHAR(30)	NOT NULL,
	SIGLA		CHAR(3)		NOT NULL,
	STATUS		BOOLEAN		NOT NULL,
	FOREIGN KEY (ID_PAIS) REFERENCES PAIS(ID)
);
CREATE TABLE CIDADE ( 
	ID 			INTEGER		NOT NULL PRIMARY KEY,
	ID_ESTADO	INTEGER		NOT NULL,
	NOME		VARCHAR(30)	NOT NULL,
	STATUS		BOOLEAN		NOT NULL,
	FOREIGN KEY (ID_ESTADO) REFERENCES ESTADO(ID)
);
CREATE TABLE CADASTRO(
	BP 			INTEGER			NOT NULL PRIMARY KEY,
	ID_CIDADE	INTEGER			NOT NULL,
	NOME_RAZAO	VARCHAR(100) 	NOT NULL,
	CPF_CNPJ	INTEGER			NOT NULL,
	RG_INSCRIC	INTEGER			NOT NULL,
	TELEFONE	INTEGER			NOT NULL,
	EMAIL		VARCHAR(50)		NOT NULL,
	ENDERECO	VARCHAR(100)	NOT NULL,
	NUMERO		INTEGER			NOT NULL,
	CEP 		INTEGER			NOT NULL,
	COMPLEMENTO	VARCHAR(100),
	STATUS		BOOLEAN			NOT NULL,
	FOREIGN KEY (ID_CIDADE) REFERENCES CIDADE(ID)
);
CREATE TABLE CATEGORIA (
	ID 			INTEGER		NOT NULL PRIMARY KEY,
	NOME 		VARCHAR(30) NOT NULL,
	STATUS		BOOLEAN		NOT NULL
);
CREATE TABLE PRODUTO(
	CODIGO			INTEGER		NOT NULL PRIMARY KEY,
	ID_CATEGORIA	INTEGER		NOT NULL,
	NOME			VARCHAR(50)	NOT NULL,
	STATUS			BOOLEAN		NOT NULL,
	FOREIGN KEY (ID_CATEGORIA) REFERENCES CATEGORIA(ID)
);
CREATE TABLE FORMA_PAGAMENTO(
	ID	 		INTEGER		NOT NULL	PRIMARY KEY,
	CONDICAO	VARCHAR(30)	NOT NULL,
	FORMA 		VARCHAR(30)	NOT NULL,
	STATUS		BOOLEAN		NOT NULL
);
CREATE TABLE VENDA(
	ID 					INTEGER		NOT NULL	PRIMARY KEY,
	BP_CADASTRO			INTEGER		NOT NULL,
	ID_FORMA_PAGAMENTO 	INTEGER		NOT NULL,
	DATA_VENDA			DATE		NOT NULL,
	VALOR_PRODUTOS		FLOAT		NOT NULL,
	DESCONTO_GERAL		FLOAT	,
	VALOR_TOTAL			FLOAT		NOT NULL,
	VENCIMENTO			DATE	,
	FOREIGN KEY (BP_CADASTRO) REFERENCES CADASTRO(BP),
	FOREIGN KEY (ID_FORMA_PAGAMENTO) REFERENCES FORMA_PAGAMENTO(ID)
);
CREATE TABLE ITEM_VENDA (
	ID 					INTEGER			NOT NULL	PRIMARY KEY,
	CODIGO_PRODUTO		INTEGER			NOT NULL,
	ID_VENDA			INTEGER			NOT NULL,
	QUANTIDADE			INTEGER			NOT NULL,
	VALOR_UNITARIO		FLOAT			NOT NULL,
	DESCONTO_UNITARIO	FLOAT	,
	VALOR_LIQUIDO		FLOAT			NOT NULL,
	VALOR_FINAL			FLOAT			NOT NULL,
	FOREIGN KEY (CODIGO_PRODUTO) REFERENCES PRODUTO(CODIGO),
	FOREIGN KEY (ID_VENDA) REFERENCES VENDA(ID)
);
CREATE TABLE ESTOQUE (
	ID 				INTEGER		NOT NULL	PRIMARY KEY,
	CODIGO_PRODUTO	INTEGER		NOT NULL,
	ID_ITEM_VENDA	INTEGER		,
	DATA_MOVIMENTO 	DATE		NOT NULL,
	TIPO_MOVIMENTO	VARCHAR(7) 	NOT NULL CHECK (UPPER(TIPO_MOVIMENTO) IN ('ENTRADA', 'SAIDA')),
	QUANTIDADE		INTEGER		NOT NULL,
	VALOR			FLOAT		,
	FOREIGN KEY (CODIGO_PRODUTO) REFERENCES PRODUTO(CODIGO),
	FOREIGN KEY (ID_ITEM_VENDA) REFERENCES ITEM_VENDA(ID)
);
CREATE TABLE SITUACAO_CONTAS (
	ID 				INTEGER		NOT NULL PRIMARY KEY,
	TIPO_SITUACAO	VARCHAR(30)	NOT NULL
);
CREATE TABLE CONTAS_RECEBER(
	ID 					INTEGER		NOT NULL	PRIMARY KEY,
	ID_VENDA			INTEGER		NOT NULL,
	ID_SITUACAO_CONTAS	INTEGER		NOT NULL,
	ACRECIMO			FLOAT		,
	PAGAMENTO_PARCIAL	FLOAT		,
	DATA_PAGAMENTO		DATE		,
	FOREIGN KEY (ID_VENDA) REFERENCES VENDA(ID),
	FOREIGN KEY (ID_SITUACAO_CONTAS) REFERENCES SITUACAO_CONTAS(ID)
);
CREATE TABLE CONTAS_PAGAR(
	ID 					INTEGER		NOT NULL PRIMARY KEY,
	BP_CADASTRO			INTEGER		NOT NULL,
	ID_SITUACAO_CONTAS	INTEGER		NOT NULL,
	DATA_DESPESA		DATE		NOT NULL,
	VALOR				FLOAT		NOT NULL,
	TIPO_DESPESA		VARCHAR(50)	NOT NULL,
	DATA_VENCIMENTO		DATE		NOT NULL,
	FOREIGN KEY	(BP_CADASTRO) REFERENCES CADASTRO(BP),
	FOREIGN KEY (ID_SITUACAO_CONTAS) REFERENCES SITUACAO_CONTAS(ID)
);
CREATE TABLE MOVIMENTACAO_CAIXA(
	ID 					INTEGER		NOT NULL PRIMARY KEY,
	ID_CONTAS_RECEBER	INTEGER		,
	ID_CONTAS_PAGAR		INTEGER		,
	DATA_MOVIMENTO		DATE		NOT NULL,
	VALOR				FLOAT		NOT NULL,
	MEIO_PAGAMENTO		VARCHAR(30)	NOT NULL,
	TIPO_MOVIMENTO		VARCHAR(7)	NOT NULL CHECK (UPPER(TIPO_MOVIMENTO) IN ('ENTRADA', 'SAIDA')),
	FOREIGN KEY (ID_CONTAS_RECEBER) REFERENCES CONTAS_RECEBER(ID),
	FOREIGN KEY (ID_CONTAS_PAGAR) REFERENCES CONTAS_PAGAR(ID)
);
CREATE TABLE SALDO_CAIXA(
	ID 						INTEGER		NOT NULL PRIMARY KEY,
	ID_MOVIMENTACAO_CAIXA	INTEGER		NOT NULL,
	DATA_SALDO				DATE		NOT NULL,
	SALDO_INICIAL			FLOAT		NOT NULL,
	VALOR_MOVIMENTACAO		FLOAT		NOT NULL,
	SALDO_FINAL				FLOAT		NOT NULL,
	FOREIGN KEY (ID_MOVIMENTACAO_CAIXA) REFERENCES MOVIMENTACAO_CAIXA(ID)
);

--H- CRIAR OS GERADORES DE ID
CREATE GENERATOR G_PAIS;
CREATE GENERATOR G_ESTADO;
CREATE GENERATOR G_CIDADE;
CREATE GENERATOR G_CADASTRO;
CREATE GENERATOR G_CATEGORIA;
CREATE GENERATOR G_PRODUTO;
CREATE GENERATOR G_FORMA_PAGAMENTO;
CREATE GENERATOR G_VENDA;
CREATE GENERATOR G_ITEM_VENDA;
CREATE GENERATOR G_ESTOQUE;
CREATE GENERATOR G_SITUACAO_CONTAS;
CREATE GENERATOR G_CONTAS_RECEBER;
CREATE GENERATOR G_CONTAS_PAGAR;
CREATE GENERATOR G_MOVIMENTACAO_CAIXA;
CREATE GENERATOR G_SALDO_CAIXA;