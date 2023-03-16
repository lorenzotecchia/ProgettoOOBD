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
    LName     varchar(20)
);

CREATE INDEX idx_name
ON mtl.author (LName, FName);

ALTER TABLE IF EXISTS mtl.author
ADD CONSTRAINT  AuthorPK primary key (CodAuthor);

create table mtl.series
(
    ISSN_S  mtl.issn,
    Curator mtl.names,
    Edition int,
    Code_S  varchar(10),
    Name_S  mtl.names
);

ALTER TABLE IF EXISTS mtl.series
ADD CONSTRAINT SeriesPK primary key (ISSN_S);

CREATE INDEX IF NOT EXISTS SeriesIndex ON mtl.series (Code_S);

create table mtl.magazine
(
    ISSN_M            mtl.issn,
    Name_M            mtl.names,
    Argument          mtl.names,
    Manager           mtl.names,
    YearRelease       timestamp,
    PublicationPeriod mtl.names,
    AccessMode        mtl.access,
    PublishingHouse   mtl.names
);

ALTER TABLE IF EXISTS mtl.magazine
ADD CONSTRAINT MagazinePk primary key (ISSN_M);

create table mtl.book
(
    ISBN_B           mtl.isbn,
    DOI_B            mtl.doi,
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

    constraint BookFK_3 foreign key (FK_Series) references mtl.Series (ISSN_S) on delete set null,
    check ( DOI_B is not null and AccessMode = 'digitale')
);

ALTER TABLE IF EXISTS mtl.book
ADD CONSTRAINT BookPk primary key (ISBN_B);

ALTER TABLE IF EXISTS mtl.book
ADD CONSTRAINT BookUnique unique (DOI_B);


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

    constraint ArticleFK_2 foreign key (FK_Magazine) references mtl.Magazine (ISSN_M) on delete set null,
    check ((FK_Magazine is not null and (ConferenceName is null and ReleaseLocation is null)) OR
           (FK_Magazine is null and (ConferenceName is not null and ReleaseLocation is not null)))
);

ALTER TABLE  IF EXISTS mtl.article
ADD CONSTRAINT ArticlePK primary key (Doi_A);

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

create view mtl.presentation as
select b.title, a.fname, a.lname, b.presentationname, b.releaselocation, b.releasedate
from (mtl.book b join mtl.author_books au on au.BooksFK = b.ISBN_B) join mtl.author a on a.codauthor=au.AuthorsFK
where presentationname is not null and releaselocation is not null
order by lname;

create view mtl.conference as
select a.title, ar.fname, ar.lname, a.conferencename, a.releaselocation, a.releasedate
from (mtl.article a join mtl.author_article au on  au.ArticlesFK = a.doi_a) join mtl.author ar on au.AuthorsFK = ar.codauthor
where a.conferencename is not null and releaselocation is not null
order by lname;