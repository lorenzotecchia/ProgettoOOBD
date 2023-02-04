create view mtl.presentation as
select b.title, a.fname, a.lname, b.presentationname, b.releaselocation, b.releasedate
from mtl.book b
         join mtl.author a on a.codauthor = b.fk_author
where presentationname is not null and releaselocation is not null
order by lname;

create view mtl.conference as
select ar.title, a.fname, a.lname, ar.conferencename, ar.releaselocation, ar.releasedate
from mtl.article ar
         join mtl.author a on a.codauthor = ar.fk_author
where conferencename is not null and releaselocation is not null
order by a.lname;