create table immeuble
(
    id                uuid primary key,
    adresse           varchar(255) not null,
    code_postal       varchar(255) not null,
    ville             varchar(255) not null,
    date_construction timestamp         not null
);

create table proprietaire
(
    id            uuid primary key,
    nom           varchar(255) not null,
    prenom        varchar(255) not null,
    numero_compte varchar(255) not null,
    assujetti_tva boolean      not null
);

create table appartement
(
    id                     uuid primary key,
    numero                 integer      not null,
    type                   varchar(255) not null,
    loyer                  float(2)     not null,
    immeuble_id            uuid         not null,
    proprietaire_id        uuid         not null,
    locataire_principal_id uuid,
    foreign key (immeuble_id) references immeuble (id),
    foreign key (proprietaire_id) references proprietaire (id)
);

create table locataire
(
    id             uuid primary key,
    nom            varchar(255) not null,
    prenom         varchar(255) not null,
    principal      boolean      not null,
    appartement_id uuid         not null,
    foreign key (appartement_id) references appartement (id)
);

create table option
(
    id   uuid primary key,
    type varchar(255) not null

);

create table appartement_option
(
    appartement_id uuid not null,
    option_id      uuid not null,
    primary key (appartement_id, option_id),
    foreign key (appartement_id) references appartement (id),
    foreign key (option_id) references option (id)
);

create table equipement
(
    id              uuid primary key,
    type            varchar(255) not null,
    securite        boolean      not null,
    date_inspection timestamp
);

create table immeuble_equipement
(
    immeuble_id   uuid not null,
    equipement_id uuid not null,
    primary key (immeuble_id, equipement_id),
    foreign key (immeuble_id) references immeuble (id),
    foreign key (equipement_id) references equipement (id)
);

alter table appartement
    add constraint fk_appartement_locataire_principal
        foreign key (locataire_principal_id) references locataire (id);