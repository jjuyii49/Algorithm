select ID, LENGTH
from FISH_INFO
where LENGTH > 10
order by LENGTH DESC, ID ASC
limit 10