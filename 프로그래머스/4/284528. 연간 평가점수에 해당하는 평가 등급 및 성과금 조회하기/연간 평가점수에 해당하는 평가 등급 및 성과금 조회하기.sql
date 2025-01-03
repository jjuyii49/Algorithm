with grade as (
    select EMP_NO, case when avg(SCORE) >= 96 then "S"
                        when avg(SCORE) >= 90 then "A"
                        when avg(SCORE) >= 80 then "B"
                        else "C" end as "GRADE"
    from HR_GRADE
    group by EMP_NO
)

select g.EMP_NO, he.EMP_NAME, g.GRADE, case when g.GRADE = "S" then he.SAL * 0.2
                                            when g.GRADE = "A" then he.SAL * 0.15
                                            when g.GRADE = "B" then he.SAL * 0.1
                                            else 0 end as "BONUS"
from grade g join HR_EMPLOYEES he
on g.EMP_NO = he.EMP_NO
order by g.EMP_NO