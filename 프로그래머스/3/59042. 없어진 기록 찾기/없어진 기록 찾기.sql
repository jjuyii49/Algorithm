select ao.ANIMAL_ID, ao.NAME
from ANIMAL_OUTS ao left join ANIMAL_INS ai
on ao.ANIMAL_ID = ai.ANIMAL_ID
where ai.ANIMAL_ID is null
order by ao.ANIMAL_ID