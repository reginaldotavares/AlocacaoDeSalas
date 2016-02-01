CREATE SEQUENCE usuario_seq;
CREATE SEQUENCE feriado_seq;

CREATE TABLE usuario
(
  id_usuario integer NOT NULL DEFAULT nextval('usuario_seq'::regclass),
  nome character varying(100) NOT NULL,
  senha character varying(30) NOT NULL,
  email character varying(60) NOT NULL,
  matricula character varying(60) NOT NULL,
  papel character varying(30) NOT NULL,
  imagem bytea,	

  PRIMARY KEY (email)
);

CREATE TABLE feriado
(
  id_feriado integer NOT NULL DEFAULT nextval('feriado_seq'::regclass),
  nomeFeriado character varying(100) NOT NULL unique,
  data date NOT NULL unique,,

  PRIMARY KEY (id_feriado)
);

insert into usuario(nome, senha, email, matricula, papel, imagem) values ("root","xs123chg",''reginaldomicrocenter@gmail.com","000000","Administrador");