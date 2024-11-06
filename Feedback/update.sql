alter table tb_instrutores add column ferias bit;
alter table tb_instrutores add column ferias bit;

    alter table tb_instrutores 
       add column ativo bit;

    create table tb_aprendiz (
        id integer not null auto_increment,
        ativo bit not null,
        curso enum ('ADM','DS','MANUFATURA','MECATRONICA'),
        edv varchar(255),
        email varchar(255),
        ferias bit,
        faculdade varchar(255),
        trilha varchar(255),
        turma varchar(255),
        nome varchar(255),
        primary key (id)
    ) engine=InnoDB;

    alter table tb_instrutores 
       modify column id integer not null auto_increment;
