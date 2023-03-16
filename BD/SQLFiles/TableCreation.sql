drop schema if exists mtl cascade;
create schema mtl;

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
    ISBN_B           mtl.isbn,
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
    FK_Series        mtl.issn,

    constraint BookPk primary key (ISBN_B),
    constraint BookFK_3 foreign key (FK_Series) references mtl.Series (ISSN_S) on delete set null
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

create table mtl.author_books(
    
    AuthorsFK serial,
    BooksFK  mtl.isbn,

    constraint autori_libriFK_1 foreign key (AuthorsFK) references mtl.author (codauthor) on delete cascade,
    constraint autori_libriFK_2 foreign key (BooksFK) references mtl.book (ISBN_B) on delete cascade
);

create table mtl.author_article
(
    AuthorsFK   serial,
    ArticlesFK mtl.doi,

    constraint autori_libriFK_1 foreign key (AuthorsFK) references mtl.author (codauthor) on delete cascade,
    constraint autori_libriFK_2 foreign key (ArticlesFK) references mtl.article (Doi_A) on delete cascade
);