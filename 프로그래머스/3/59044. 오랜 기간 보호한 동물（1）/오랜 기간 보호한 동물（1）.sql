select NAME, DATETIME
from ANIMAL_INS
where ANIMAL_ID not in (select ai.ANIMAL_ID
from ANIMAL_INS ai join ANIMAL_OUTS ao
on ai.ANIMAL_ID = ao.ANIMAL_ID)
order by DATETIME
limit 3