with review as (
    select MEMBER_ID, REVIEW_TEXT, REVIEW_DATE
    from REST_REVIEW
    where MEMBER_ID = (select MEMBER_ID from REST_REVIEW group by MEMBER_ID order by count(*) desc limit 1)
)

select mp.MEMBER_NAME, r.REVIEW_TEXT, left(r.REVIEW_DATE, 10) as 'REVIEW_DATE'
from MEMBER_PROFILE mp join review r
on mp.MEMBER_ID = r.MEMBER_ID
order by REVIEW_DATE, REVIEW_TEXT