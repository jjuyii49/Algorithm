select fi.ID, fni.FISH_NAME, fi.LENGTH
from FISH_INFO fi join FISH_NAME_INFO fni
on fi.FISH_TYPE = fni.FISH_TYPE
where (fi.FISH_TYPE, fi.LENGTH) in (select FISH_TYPE, MAX(LENGTH) from FISH_INFO group by FISH_TYPE)
order by fi.ID