select distinct ID, EMAIL, FIRST_NAME, LAST_NAME
from DEVELOPERS
where BIN(SKILL_CODE) & (select CODE from SKILLCODES where NAME ="Python") != 0 or
        BIN(SKILL_CODE) & (select CODE from SKILLCODES where NAME ="C#") != 0
order by ID