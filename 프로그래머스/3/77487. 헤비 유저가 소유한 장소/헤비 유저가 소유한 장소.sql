with heavy as (
    select HOST_ID
    from PLACES
    group by HOST_ID
    having count(*) >= 2
)

select p.ID, p.NAME, p.HOST_ID
from PLACES p join heavy h
on p.HOST_ID = h.HOST_ID
order by p.ID