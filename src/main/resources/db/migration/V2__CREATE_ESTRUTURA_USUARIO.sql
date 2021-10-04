create table audit.usuario
(
    codigo    bigint  not null,
    rev       integer not null
        constraint usuario_rev_fk
            references revinfo,
    revtype   smallint,
    cidade    varchar(255),
    cpf       varchar(255),
    email     varchar(255),
    matricula integer,
    nome      varchar(255),
    constraint usuario_pkey
        primary key (codigo, rev)
);

alter table audit.usuario owner to hibernate;
