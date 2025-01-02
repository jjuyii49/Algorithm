select ed1.ID
from ECOLI_DATA ed1 join ECOLI_DATA ed2
on ed1.PARENT_ID = ed2.ID
join ECOLI_DATA ed3 on ed2.PARENT_ID = ed3.ID and ed3.PARENT_ID is null
order by ed1.ID