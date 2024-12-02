select ed.ID, case when p.count is null then 0
                    else p.count end CHILD_COUNT
from ECOLI_DATA ed left join (select PARENT_ID, count(*) as count from ECOLI_DATA group by(PARENT_ID)) p
on ed.ID = p.PARENT_ID
