drop schema if exists mtl cascade;
create schema mtl;

create domain mtl.issn as varchar(9)
    check ( value like '%-%'
        and value not similar to '%[a-z]+%'
        and value not similar to '%[A-Z]+%'
        and value not similar to '%[@!#$ˆ∗%&]+%');

create domain mtl.isbn as varchar(17)
    check ( value like '%-_-%-%-_');

create domain mtl.doi as varchar(30)
    check ( value like '10.%/%');

create domain mtl.access as varchar(20)
    check ( value <> '' and value not similar to '%[0-9]+%'
        and value not similar to '%[@!#$ˆ∗%&]+%');

create domain mtl.names as varchar(30)
    check ( value not similar to '%[@!#$ˆ∗%&]+%');

create domain mtl.location as varchar(50)
    check ( value like '%,%,%,%,%'
        and value not similar to '%[@!#$ˆ∗%&]+%');



create table mtl.author
(
    CodAuthor serial,
    FName     varchar(20),
    LName     varchar(20),

    constraint AuthorPK primary key (CodAuthor)
);

create table mtl.series
(
    ISSN_S  mtl.issn,
    Curator mtl.names,
    Edition int,
    Code_S  varchar(10) unique,
    Name_S  mtl.names,

    constraint SeriesPK primary key (ISSN_S)
);

create table mtl.magazine
(
    ISSN_M            mtl.issn,
    Name_M            mtl.names,
    Argument          mtl.names,
    Manager           mtl.names,
    YearRelease       timestamp,
    PublicationPeriod mtl.names,
    AccessMode        mtl.access,
    PublishingHouse   mtl.names,

    constraint MagazinePk primary key (ISSN_M)
);


create table mtl.book
(
    Doi_B            mtl.doi,
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

    constraint BookPk primary key (Doi_B),
    constraint BookFK_3 foreign key (FK_Series) references mtl.Series (ISSN_S) on delete set null
);

create table mtl.autori_libri(
    fk_autori serial,
    fk_libri mtl.doi,

    constraint autori_libriFK_1 foreign key (fk_autori) references mtl.author(codauthor) on delete cascade,
    constraint autori_libriFK_2 foreign key (fk_libri) references mtl.book(Doi_B) on delete cascade
);

create table mtl.autori_articoli(
    fk_autori serial,
    fk_articoli mtl.doi,

    constraint autori_libriFK_1 foreign key (fk_autori) references mtl.author(codauthor) on delete cascade,
    constraint autori_libriFK_2 foreign key (fk_articoli) references mtl.article(Doi_A) on delete cascade
);

create table mtl.article
(
    Doi_A           mtl.doi,
    Title           varchar(40),
    AccessMode      mtl.access,
    Editor          mtl.names,
    Topic           mtl.names,
    ReleaseDate     timestamp,
    ReleaseLocation mtl.location,
    ConferenceName  varchar(50),
    FK_Magazine     mtl.issn,

    constraint ArticlePK primary key (Doi_A),
    constraint ArticleFK_2 foreign key (FK_Magazine) references mtl.Magazine (ISSN_M) on delete set null,
    check ((FK_Magazine is not null and (ConferenceName is null and ReleaseLocation is null)) OR
           (FK_Magazine is null and (ConferenceName is not null and ReleaseLocation is not null)))
);