-- --Trigger per il controllo del numero massimo di oggetti per prestito
-- create or replace function mtl.function_1()
--     returns trigger as
-- $$
-- begin
--     delete from mtl.drawing where fk_loancode = new.fk_loancode;
--     delete from mtl.loan where loancode = new.fk_loancode;
--     raise notice 'numero massimo raggiunto';
--     return new;
-- end;
--
-- $$
--     language plpgsql;
--
-- create trigger trigger_prestito
--     after insert
--     on mtl.drawing
--     for each row
--     when ( new.fk_book is not null and
--            new.fk_article is not null and
--            new.fk_series is not null and
--            new.fk_magazine is not null)
-- execute procedure mtl.function_1();
--
--
-- --Trigger per il ritorno dei libri
-- create or replace function mtl.function_2()
--     returns trigger as
-- $$
-- begin
--     if(date(new.endloan) = current_date) then
--             delete from mtl.loan where loancode=new.loancode;
--     end if;
--     return new;
-- end;
-- $$
-- language plpgsql;
--
-- create trigger trigger_loan
--     after update or insert
--     on mtl.loan
--     for each row
-- execute procedure mtl.function_2();
--
--
-- /*
-- Quando si inserisce loan si dovrebbe automaticamente inserire anche drawing
-- -> Risolto il programma la gui gestirà le due cose in due tempi diversi
-- poichè semplicemente appena fai un prestito non sai a prescindere quali libri prendere
-- se sono disponibili o no ecc.....
-- */
--
--
-- create or replace function mtl.info_libri(libro_in mtl.book.title%TYPE) returns text
-- as
-- $$
--     declare
--         output record;
--         query text := 'select *' ||
--                       ' from mtl.book b where b.title =';
--     begin
--         query = query || ''''|| libro_in ||'''' ||';';
--         raise notice '{%}',query;
--         execute query into output;
--         return output;
--     end
-- $$ language plpgsql;
--
-- --Storico Articoli, tutte le info
-- create or replace function mtl.info_articoli(articolo_in mtl.article.title%TYPE) returns text
-- as
-- $$
--     declare
--         output record;
--         query text := 'select a.title,a.accessmode, date(a.yearrelease), a.editor, a.author' ||
--                       ' from mtl.article a where a.title =';
--     begin
--         query = query || ''''||articolo_in ||'''' ||';';
--         raise notice '{%}',query;
--         execute query into output;
--         return output;
--     end
-- $$ language plpgsql;
--
--
-- create or replace function mtl.info_collane(collana_in mtl.book.title%TYPE) returns varchar
-- as
-- $$
--     declare
--         output record;
--         query text := 'select *' ||
--                       ' from mtl.series s where s.nameS =';
--     begin
--         query = query || ''''|| collana_in ||'''' ||';';
--         raise notice '{%}',query;
--         execute query into output;
--         return output;
--     end
-- $$ language plpgsql;
--
-- create or replace function mtl.info_riviste(rivista_in mtl.book.title%TYPE) returns varchar
-- as
-- $$
--     declare
--         output record;
--         query text := 'select *' ||
--                       ' from mtl.magazine m where m.namem =';
--     begin
--         query = query || ''''|| rivista_in ||'''' ||';';
--         raise notice '{%}',query;
--         execute query into output;
--         return output;
--     end
-- $$ language plpgsql;

-- call mtl.info_libri('The Divine');
-- select distinct *
-- from mtl.book
-- where title='The Divine' and edition='3';

create trigger trigger_books
    after insert
    on mtl.book
execute procedure mtl.function_1();

create function mtl.function_1() returns trigger as

$$
begin

end;
$$;

create function info_libro_per_autore(nome_in mtl.author.fname%TYPE, cognome_in mtl.author.lname%TYPE)
    returns table(last_name varchar,isbn varchar, doi varchar, title varchar, edition integer, release date) as
$$
    begin
    return (select a.lname,b.isbn_b,b.doi_b,b.title,b.edition,date(b.releasedate)
            from mtl.book b, mtl.author a
            where a.fname = nome_in and a.lname = cognome_in and a.codauthor = b.author);
    end;
    $$
    language plpgsql;

create function info_articoli_per_autore(nome_in mtl.author.fname%TYPE, cognome_in mtl.author.lname%TYPE)
    returns table(last_name varchar,isbn varchar, doi varchar, title varchar, edition integer, release date) as
$$
    begin
    return (select a.lname,ar.doi_a,ar.title,ar.editor,date(ar.yearrelease)
            from mtl.article ar, mtl.author a
            where a.fname = nome_in and a.lname = cognome_in and a.codauthor = ar.author);
    end;
    $$
    language plpgsql;

create function info_libro_per_argomento(argomento_in mtl.book.argument%TYPE)
    returns table(last_name varchar,isbn varchar, doi varchar, title varchar, edition integer, release date) as
$$
    begin
    return (select a.lname,b.isbn_b,b.doi_b,b.title,b.edition,date(b.releasedate)
            from mtl.book b, mtl.author a
            where b.argument=argomento_in and a.codauthor = b.author);
    end;
    $$
    language plpgsql;

create function info_articoli_per_argomento(argomento_in mtl.article.topic%TYPE)
    returns table(last_name varchar,isbn varchar, doi varchar, title varchar, edition integer, release date) as
$$
    begin
    return (select a.lname,ar.doi_a,ar.title,ar.editor,date(ar.yearrelease)
            from mtl.article ar, mtl.author a
            where ar.topic=argomento_in and a.codauthor = ar.author);
    end;
    $$
    language plpgsql;



