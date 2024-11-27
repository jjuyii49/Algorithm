select year(e.DIFFERENTIATION_DATE) "YEAR", m.maximum - e.SIZE_OF_COLONY "YEAR_DEV", e.ID
from ECOLI_DATA e join (select year(DIFFERENTIATION_DATE) "y", max(SIZE_OF_COLONY) "maximum"
                        from ECOLI_DATA
                        group by year(DIFFERENTIATION_DATE)) m
on year(e.DIFFERENTIATION_DATE) = m.y
order by YEAR asc, YEAR_DEV asc