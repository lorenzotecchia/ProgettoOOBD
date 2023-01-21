-- --Tabella virtuale con tutti i libri disponibili
-- create view mtl.available_books as
--     select distinct b.Doi_B
--     from mtl.book b
--     where b.AccessMode = 'Paper'
--     except
--         (select distinct b.fk_book
--         from mtl.drawing b);
-- 
-- 
-- --Tabella virtuale con tutti gli articoli disponibili
-- create view mtl.available_articles as
--     select distinct a.Doi_A
--     from mtl.article a
--     where a.AccessMode = 'Paper'
--     except
--         (select distinct b.fk_article
--         from mtl.drawing b);
-- 
-- 
-- --Tabella virtuale con tutte le collane disponibili
-- create view mtl.available_series as
--     select distinct s.issn_s
--     from mtl.series s
--     where s.AccessMode = 'Paper'
--     except
--         (select distinct b.fk_series
--         from mtl.drawing b);
-- 
-- 
-- --Tabella virtuale con tutte le riviste disponibili
-- create view mtl.available_magazine as
--     select distinct m.issn_m
--     from mtl.magazine m
--     where m.AccessMode = 'Paper'
--     except
--         (select distinct b.fk_magazine
--         from mtl.drawing b);


create view mtl.bibliography as
select distinct b.Title,b.ReleaseDate,a.lname
from mtl.book b join mtl.author a on b.author = a.codauthor
order by b.releasedate desc;

create view mtl.history as
select distinct a.fname, a.lname, ar.title,ar.yearrelease,ar.editor
from mtl.author a join mtl.article ar on a.codauthor = ar.author
order by ar.yearrelease desc;

create view mtl.digital_goods as
select distinct b.title from mtl.book b where accessmode = 'Digital'
union
select distinct a.title from mtl.article a where accessmode = 'Digital'
union
select distinct m.namem  from mtl.magazine m where accessmode = 'Digital'
union
select distinct s.names from mtl.series s where accessmode = 'Digital';

create view mtl.paper_goods as
select distinct b.title from mtl.book b where accessmode = 'Paper'
union
select distinct a.title from mtl.article a where accessmode = 'Paper'
union
select distinct m.namem  from mtl.magazine m where accessmode = 'Paper'
union
select distinct s.names from mtl.series s where accessmode = 'Paper';


create view mtl.audio_goods as
select distinct b.title from mtl.book b where accessmode = 'Audio'
union
select distinct a.title from mtl.article a where accessmode = 'Audio'
union
select distinct m.namem  from mtl.magazine m where accessmode = 'Audio'
union
select distinct s.names from mtl.series s where accessmode = 'Audio';

