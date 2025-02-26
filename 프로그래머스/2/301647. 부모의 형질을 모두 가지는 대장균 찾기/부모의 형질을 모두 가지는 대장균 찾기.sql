select e1.ID "ID", e1.GENOTYPE "GENOTYPE", e2.GENOTYPE "PARENT_GENOTYPE"
from ECOLI_DATA e1 join ECOLI_DATA e2
on e1.PARENT_ID = e2.ID
where e1.GENOTYPE & e2.GENOTYPE = e2.GENOTYPE
order by ID