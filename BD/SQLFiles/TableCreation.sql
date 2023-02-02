drop schema if exists mtl  cascade;
create schema mtl;

create table mtl.author
(
    CodAuthor serial
        primary key,
    FName     varchar(20),
    LName     varchar(20)
);

create table mtl.series
(
    ISSN_S  mtl.issn primary key,
    Curator mtl.names,
    Edition int,
    Code_S  varchar(10) unique,
    Name_S  mtl.names
);

create table mtl.magazine
(
    ISSN_M            mtl.issn primary key,
    Name_M            mtl.names,
    Argument          mtl.names,
    Manager           mtl.names,
    YearRelease       timestamp,
    PublicationPeriod mtl.names,
    AccessMode        mtl.access,
    PublishingHouse   mtl.names
);


create table mtl.book
(
    Doi_B            mtl.doi
        primary key,
    ISBN_B           mtl.isbn
        unique,
    PublishingHouse  mtl.names,
    Language         mtl.names,
    AccessMode       mtl.access,
    Title            varchar(30),
    Argument         mtl.names,
    Reprint          boolean,
    Edition          int,
    ReleaseDate      timestamp,
    ReleaseLocation  mtl.location,
    PresentationName mtl.names,
    FK_Author        serial,
    FK_Series        mtl.issn,

    constraint BookFK_2 foreign key (Fk_Author) references mtl.Author (CodAuthor) on delete cascade,
    constraint BookFK_3 foreign key (FK_Series) references mtl.Series (ISSN_S) on delete set null
);

create table mtl.article
(
    Doi_A           mtl.doi
        primary key,
    Title           varchar(40),
    AccessMode      mtl.access,
    Editor          mtl.names,
    Topic           mtl.names,
    ReleaseDate     timestamp,
    ReleaseLocation mtl.location,
    ConferenceName  varchar(50),
    FK_Author       serial,
    FK_Magazine     mtl.issn,

    constraint ArticleFK_1 foreign key (FK_Author) references mtl.Author (CodAuthor) on delete cascade,
    constraint ArticleFK_2 foreign key (FK_Magazine) references mtl.Magazine (ISSN_M) on delete set null
);