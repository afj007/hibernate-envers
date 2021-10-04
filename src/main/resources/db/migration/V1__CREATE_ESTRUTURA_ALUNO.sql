CREATE TABLE usuario
(
    codigo    integer      not null primary key ,
    nome      varchar(100) not null,
    matricula integer      null,
    cpf       varchar(45)  null,
    email     varchar(255) null,
    cidade    varchar(255) null
);


CREATE TABLE aluno
(
    codigo    integer      not null primary key ,
    nome      varchar(100) not null,
    matricula integer      null,
    cpf       varchar(45)  null,
    email     varchar(255) null,
    cidade    varchar(255) null,
    id_usuario integer not null constraint aluno_usuario_fk
        references usuario
);

create schema audit;

create table revinfo
(
    rev      integer not null
        constraint revinfo_pkey
            primary key,
    revtstmp bigint
);

alter table revinfo
    owner to hibernate;



create table audit.aluno
(
    codigo    bigint  not null,
    rev       integer not null
        constraint aluno_rev_fk
            references revinfo,
    revtype   smallint,
    cidade    varchar(255),
    cpf       varchar(255),
    email     varchar(255),
    matricula integer,
    nome      varchar(255),
    id_usuario integer not null constraint aluno_aud_usuario_aud_fk
        references usuario,
    constraint aluno_pkey
        primary key (codigo, rev)
);

alter table audit.aluno owner to hibernate;

create sequence hibernate_sequence;

alter sequence hibernate_sequence owner to hibernate;
