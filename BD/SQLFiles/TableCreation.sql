-- drop schema mtl cascade;
create schema mtl;

create type mtl.AccessMode as enum (
        'Audio',
        'Digital',
        'Paper'
    );

create table mtl.Event
(
    "CodEvent"         serial
        primary key,
    "StartDate"        timestamp,
    "EndDate"          timestamp,
    "LocationPromoter" varchar(20),
    "Manager"          varchar(20)
);

comment on table mtl.event is 'Creation of the table event';

create table mtl.Book
(
    "Doi_B"           varchar(50)
        primary key,
    ISBN_B            varchar(20)
        unique,
    "Edtion"          int,
    "ReleaseDate"     timestamp,
    "PublishingHouse" varchar(20),
    "Author"          varchar(60),
    "AccessMode"      mtl.AccessMode,
    "Title"           varchar(10),
    "Argument"        varchar(10),
    "Reprint"          boolean,
    "FK_Series"       varchar(20)
);

create table mtl.Series
(
    ISSN_S       varchar(20) primary key,
    "Curator"    varchar(20),
    "Edition"    int,
    "Name"       varchar(10),
    "AccessMode" mtl.accessmode
);
create table mtl.Magazine
(
    ISSN_M        varchar(20) primary key,
    "Argument"    varchar(10),
    "Manager"     varchar(20),
    "YearRelease" timestamp,
    "NameM"       varchar(10),
    "AccessMode"  mtl.accessmode
);

comment on table mtl.Magazine is 'Creation of the table Magazine';

create table mtl.Article
(
    "Doi_A"       varchar(20)
        primary key,
    "Title"       varchar(40),
    "AccessMode"  mtl.accessmode,
    "YearRelease" timestamp,
    "Editor"      varchar(10),
    "Author"      varchar(60),
    "FK_Magazine" varchar(20)
);

comment on table mtl.Article is 'Creation of table Article';

create table mtl.Loan
(
    "LoanCode"  serial
        primary key,
    "StartLoan" timestamp,
    "EndLoan"   timestamp,
    "FK_User"   varchar(11),

    constraint LoanFK foreign key ("FK_User") references mtl.User ("SSN")
);

alter table mtl.Loan
    owner to "lorenzotecchia";

comment on table mtl.Loan is 'Creation of the table Loan';

create table mtl.User
(
    "SSN" varchar(20)
        primary key,
    password varchar(100)
        unique
);

comment on table mtl.User is 'Creation of the table User';

create table mtl.Discussion
(
    FK_Event   serial,
    FK_Article varchar(20),

    constraint DiscussionFK_1 foreign key (FK_Event) references mtl.Event ("CodEvent"),
    constraint DiscussionFK_2 foreign key (FK_Article) references mtl.article ("Doi_A")
);

comment on table mtl.Discussion is 'Creation of the table';


create table mtl.Presentation
(
    FK_Event serial,
    FK_Book  varchar(20),

    constraint PresentationFK_1 foreign key (FK_Event) references mtl.Event ("CodEvent"),
    constraint PresentationFK_2 foreign key (FK_Book) references mtl.Book ("Doi_B")
);

comment on table mtl.Presentation is 'Creation of the table Presentation';

create table mtl.Drawing
(
    FK_LoanCode serial,
    FK_Article  varchar(20),
    Fk_Series   varchar(20),
    Fk_Magazine varchar(20),
    Fk_Book     varchar(20),

    constraint DrawingFK_1 foreign key (FK_LoanCode) references mtl.Loan ("LoanCode"),
    constraint DrawingFK_2 foreign key (FK_Article) references mtl.Article ("Doi_A"),
    constraint DrawingFK_3 foreign key (Fk_Book) references mtl.Book ("Doi_B"),
    constraint DrawingFK_4 foreign key (Fk_Series) references mtl.Series ("issn_s"),
    constraint DrawingFK_5 foreign key (Fk_Magazine) references mtl.Magazine ("issn_m")
);

comment on table mtl.Drawing is 'Creation of the table Drawing';