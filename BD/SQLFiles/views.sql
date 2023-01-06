--Tabella virtuale con tutti i libri disponibili
create view mtl.available_books as
    select distinct b.Doi_B
    from mtl.book b
    where b.AccessMode = 'Paper'
    except
        (select distinct b.fk_book
        from mtl.drawing b);


--Tabella virtuale con tutti gli articoli disponibili
create view mtl.available_articles as
    select distinct a.Doi_A
    from mtl.article a
    where a.AccessMode = 'Paper'
    except
        (select distinct b.fk_article
        from mtl.drawing b);


--Tabella virtuale con tutte le collane disponibili
create view mtl.available_series as
    select distinct s.issn_s
    from mtl.series s
    where s.AccessMode = 'Paper'
    except
        (select distinct b.fk_series
        from mtl.drawing b);


--Tabella virtuale con tutte le riviste disponibili
create view mtl.available_magazine as
    select distinct m.issn_m
    from mtl.magazine m
    where m.AccessMode = 'Paper'
    except
        (select distinct b.fk_magazine
        from mtl.drawing b);



select distinct b.Title
from mtl.available_books av natural join mtl.book b;
