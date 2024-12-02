-- 코드를 입력하세요
SELECT BOOK_ID, left(PUBLISHED_DATE, 10)
from BOOK
where year(PUBLISHED_DATE) = 2021 and CATEGORY = "인문"
order by PUBLISHED_DATE