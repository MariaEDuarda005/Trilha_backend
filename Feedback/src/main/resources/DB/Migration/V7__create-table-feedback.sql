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