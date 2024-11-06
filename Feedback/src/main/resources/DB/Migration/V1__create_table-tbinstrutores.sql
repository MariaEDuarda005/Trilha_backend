create table tb_instrutores (
    id bigint not null auto_increment,
    disciplina varchar(255),
    edv varchar(255),
    email varchar(255),
    faculdade varchar(255),
    nome varchar(255),
    trilha varchar(255),
    turma varchar(255),
    curso enum ('ADM','DS','MANUFATURA','MECATRONICA'),
    primary key (id)) engine=InnoDB;
