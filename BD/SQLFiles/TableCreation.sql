drop schema mtl cascade;
create schema mtl;

-- create table mtl.series
create table mtl.series
(
    ISSN_S          varchar(20) primary key,
    Curator         varchar(20),
    Edition         int,
    NameS           varchar(10),
    AccessMode      varchar(10),
    PublishingHouse varchar(20)
);
--create table mtl.magazine
create table mtl.magazine
(
    ISSN_M            varchar(20) primary key,
    Argument          varchar(10),
    Manager           varchar(20),
    YearRelease       timestamp,
    PublicationPeriod varchar(20),
    NameM             varchar(30),
    AccessMode        varchar(10),
    PublishingHouse   varchar(20)
);

--create table mtl.author
create table mtl.author
(
    CodAuthor serial
        primary key,
    FName     varchar(20),
    LName     varchar(20)
);

--create table mtl.article
create table mtl.article
(
    Doi_A       varchar(20)
        primary key,
    Title       varchar(40),
    AccessMode  varchar(10),
    YearRelease timestamp,
    Editor      varchar(30),
    Author      serial,
    Topic       varchar(20),
    FK_Magazine varchar(20),

    constraint ArticleFK_1 foreign key (Author) references mtl.Author (CodAuthor) on delete cascade,
    constraint ArticleFK_2 foreign key (FK_Magazine) references mtl.Magazine (ISSN_M)
);

--create table mtl.book
create table mtl.book
(
    Doi_B           varchar(50)
        primary key,
    ISBN_B          varchar(20)
        unique,
    ReleaseDate     timestamp,
    ReleaseLocation varchar(50),
    PublishingHouse varchar(20),
    Edition         int,
    Author          serial,
    AccessMode      varchar(10),
    Title           varchar(30),
    Argument        varchar(20),
    Reprint         boolean,
    FK_Series       varchar(20),

    constraint BookFK_2 foreign key (Author) references mtl.Author (CodAuthor) on delete cascade,
    constraint BookFK_3 foreign key (FK_Series) references mtl.Series (ISSN_S)
);