create function mtl.function_1() returns trigger as

$$
begin

end;
$$
language plpgsql;

create trigger trigger_books
    after insert
    on mtl.book
execute procedure mtl.function_1();


-- create function info_libro_per_autore(nome_in mtl.author.fname%TYPE, cognome_in mtl.author.lname%TYPE)
--     returns table(last_name varchar,isbn varchar, doi varchar, title varchar, edition integer, release date) as
-- $$
--     begin
--     return (select a.lname,b.isbn_b,b.doi_b,b.title,b.edition,date(b.releasedate)
--             from mtl.book b, mtl.author a
--             where a.fname = nome_in and a.lname = cognome_in and a.codauthor = b.fk_author);
--     end;
--     $$
--     language plpgsql;
--
-- create function info_articoli_per_autore(nome_in mtl.author.fname%TYPE, cognome_in mtl.author.lname%TYPE)
--     returns table(last_name varchar,isbn varchar, doi varchar, title varchar, edition integer, release date) as
-- $$
--     begin
--     return (select a.lname,ar.doi_a,ar.title,ar.editor,date(ar.yearrelease)
--             from mtl.article ar, mtl.author a
--             where a.fname = nome_in and a.lname = cognome_in and a.codauthor = ar.fk_author);
--     end;
--     $$
--     language plpgsql;
--
-- create function info_libro_per_argomento(argomento_in mtl.book.argument%TYPE)return as
-- $$
--     begin
--     return query (select a.lname,b.isbn_b,b.doi_b,b.title,b.edition,date(b.releasedate)
--             from mtl.book b, mtl.author a
--             where b.argument=argomento_in and a.codauthor = b.fk_author);
--     end;
--     $$
--     language plpgsql;
--
-- create function info_articoli_per_argomento(argomento_in mtl.article.topic%TYPE)
--     returns table(last_name varchar,isbn varchar, doi varchar, title varchar, edition integer, release date) as
-- $$
--     begin
--     return (select a.lname,ar.doi_a,ar.title,ar.editor,date(ar.yearrelease)
--             from mtl.article ar, mtl.author a
--             where ar.topic=argomento_in and a.codauthor = ar.fk_author);
--     end;
--     $$
--     language plpgsql;
--
--
