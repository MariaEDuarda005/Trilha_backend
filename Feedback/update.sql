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

    create table tb_usuario (
        id integer not null auto_increment,
        login varchar(255),
        senha varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table tb_feedback (
        id integer not null auto_increment,
        date_time datetime(6),
        aprendiz_id integer,
        instrutor_id integer,
        primary key (id)
    ) engine=InnoDB;

    alter table tb_feedback
       add constraint FKabycltpabg934pc8f13vq9clk 
       foreign key (aprendiz_id) 
       references tb_aprendiz (id);

    alter table tb_feedback
       add constraint FKrg6ve800am2mrbe0qt966b11x 
       foreign key (instrutor_id) 
       references tb_instrutores (id);
