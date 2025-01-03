select hd.DEPT_ID, hd.DEPT_NAME_EN, round(avg(he.SAL), 0) as "AVG_SAL"
from HR_EMPLOYEES he join HR_DEPARTMENT hd
on he.DEPT_ID = hd.DEPT_ID
group by he.DEPT_ID
order by AVG_SAL desc