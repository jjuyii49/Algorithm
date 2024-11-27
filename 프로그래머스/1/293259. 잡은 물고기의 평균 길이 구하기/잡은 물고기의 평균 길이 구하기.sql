select round((sum(LENGTH) + 10 * (select count(*) from FISH_INFO where LENGTH is null)) / count(*), 2) "AVERAGE_LENGTH"
from FISH_INFO