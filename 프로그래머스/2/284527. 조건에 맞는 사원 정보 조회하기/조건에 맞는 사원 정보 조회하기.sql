with grade as (
    select EMP_NO, sum(SCORE) sc
    from HR_GRADE
    group by EMP_NO
)

select g.sc SCORE, e.EMP_NO, e.EMP_NAME, e.POSITION, e.EMAIL
from HR_EMPLOYEES e join grade g
on e.EMP_NO = g.EMP_NO
where g.sc = (select max(sc) from grade)