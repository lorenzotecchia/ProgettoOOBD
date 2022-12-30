drop schema MarcianoTecchiaLibrary cascade;
create schema MarcianoTecchiaLibrary;

create type marcianotecchialibrary.AccessMode as enum (
        'Audio',
        'Digital',
        'Paper'
    );

create table marcianotecchialibrary.Event
(
    "CodEvent"         serial
        primary key,
    "StartDate"        timestamp,
    "EndDate"          timestamp,
    "LocationPromoter" varchar(20),
    "Manager"          varchar(20)
);

comment on table marcianotecchialibrary.event is 'Creation of the table event';

create table marcianotecchialibrary.Book
(
    "Doi_B"           varchar(50)
        primary key,
    ISBN_B            varchar(20)
        unique,
    "Edtion"          int,
    "ReleaseDate"     timestamp,
    "PublishingHouse" varchar(20),
    "Author"          varchar(60),
    "AccessMode"      marcianotecchialibrary.AccessMode,
    "Title"           varchar(10),
    "Argument"        varchar(10),
    "Reprint"          boolean,
    "FK_Series"       varchar(20)
);

create table marcianotecchialibrary.Series
(
    ISSN_S       varchar(20) primary key,
    "Curator"    varchar(20),
    "Edition"    int,
    "Name"       varchar(10),
    "AccessMode" marcianotecchialibrary.accessmode
);
create table marcianotecchialibrary.Magazine
(
    ISSN_M        varchar(20) primary key,
    "Argument"    varchar(10),
    "Manager"     varchar(20),
    "YearRelease" timestamp,
    "NameM"       varchar(10),
    "AccessMode"  marcianotecchialibrary.accessmode
);

comment on table marcianotecchialibrary.Magazine is 'Creation of the table Magazine';

create table marcianotecchialibrary.Article
(
    "Doi_A"       varchar(20)
        primary key,
    "Title"       varchar(40),
    "AccessMode"  marcianotecchialibrary.accessmode,
    "YearRelease" timestamp,
    "Editor"      varchar(10),
    "Author"      varchar(60),
    "FK_Magazine" varchar(20)
);

comment on table marcianotecchialibrary.Article is 'Creation of table Article';

create table marcianotecchialibrary.Loan
(
    "LoanCode"  serial
        primary key,
    "StartLoan" timestamp,
    "EndLoan"   timestamp,
    "FK_User"   varchar(11),

    constraint LoanFK foreign key ("FK_User") references marcianotecchialibrary.User ("SSN")
);

comment on table marcianotecchialibrary.Loan is 'Creation of the table Loan';

create table marcianotecchialibrary.User
(
    "SSN" varchar(20)
        primary key,
    password varchar(100)
        unique
);

comment on table marcianotecchialibrary.User is 'Creation of the table User';

create table marcianotecchialibrary.Discussion
(
    FK_Event   serial,
    FK_Article varchar(20),

    constraint DiscussionFK_1 foreign key (FK_Event) references marcianotecchialibrary.Event ("CodEvent"),
    constraint DiscussionFK_2 foreign key (FK_Article) references marcianotecchialibrary.article ("Doi_A")
);

comment on table marcianotecchialibrary.Discussion is 'Creation of the table';


create table marcianotecchialibrary.Presentation
(
    FK_Event serial,
    FK_Book  varchar(20),

    constraint PresentationFK_1 foreign key (FK_Event) references marcianotecchialibrary.Event ("CodEvent"),
    constraint PresentationFK_2 foreign key (FK_Book) references marcianotecchialibrary.Book ("Doi_B")
);

comment on table marcianotecchialibrary.Presentation is 'Creation of the table Presentation';

create table marcianotecchialibrary.Drawing
(
    FK_LoanCode serial,
    FK_Article  varchar(20),
    Fk_Series   varchar(20),
    Fk_Magazine varchar(20),
    Fk_Book     varchar(20),

    constraint DrawingFK_1 foreign key (FK_LoanCode) references marcianotecchialibrary.Loan ("LoanCode"),
    constraint DrawingFK_2 foreign key (FK_Article) references marcianotecchialibrary.Article ("Doi_A"),
    constraint DrawingFK_3 foreign key (Fk_Book) references marcianotecchialibrary.Book ("Doi_B"),
    constraint DrawingFK_4 foreign key (Fk_Series) references marcianotecchialibrary.Series ("issn_s"),
    constraint DrawingFK_5 foreign key (Fk_Magazine) references marcianotecchialibrary.Magazine ("issn_m")
);

comment on table marcianotecchialibrary.Drawing is 'Creation of the table Drawing';