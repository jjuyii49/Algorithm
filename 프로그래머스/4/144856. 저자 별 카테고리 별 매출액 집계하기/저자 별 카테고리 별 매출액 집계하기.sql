with total_sales as (
    select BOOK_ID, sum(SALES) as "TOTAL_SALES"
    from BOOK_SALES
    where year(SALES_DATE) = 2022 and month(SALES_DATE) = 1
    group by BOOK_ID
)

select a.AUTHOR_ID, a.AUTHOR_NAME, b.CATEGORY, sum(b.PRICE * ts.TOTAL_SALES) as "TOTAL_SALES"
from BOOK b join AUTHOR a on b.AUTHOR_ID = a.AUTHOR_ID
join total_sales ts on b.BOOK_ID = ts.BOOK_ID
group by a.AUTHOR_ID, b.CATEGORY
order by a.AUTHOR_ID asc, b.CATEGORY desc