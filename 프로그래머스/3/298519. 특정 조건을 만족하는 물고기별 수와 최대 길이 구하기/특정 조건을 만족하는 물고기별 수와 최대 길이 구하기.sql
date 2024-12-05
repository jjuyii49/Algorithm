select count(*) FISH_COUNT, max(LENGTH) MAX_LENGTH, FISH_TYPE
from FISH_INFO
group by FISH_TYPE
having avg(case when LENGTH is null then 10
          else LENGTH end) >= 33
order by FISH_TYPE