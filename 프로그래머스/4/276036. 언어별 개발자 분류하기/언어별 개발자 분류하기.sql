with grade as (
    select case when SKILL_CODE & (select sum(CODE) from SKILLCODES where CATEGORY = "Front End") != 0
                and SKILL_CODE & (select CODE from SKILLCODES where NAME = "Python") != 0 then "A"
            when SKILL_CODE & (select CODE from SKILLCODES where NAME = "C#") != 0 then "B"
            when SKILL_CODE & (select sum(CODE) from SKILLCODES where CATEGORY = "Front End") != 0 then "C"
            end as "GRADE", ID
    from DEVELOPERS
)

select g.GRADE, d.ID, d.EMAIL
from DEVELOPERS d join grade g
on d.ID = g.ID
where g.GRADE is not null
order by g.GRADE, ID