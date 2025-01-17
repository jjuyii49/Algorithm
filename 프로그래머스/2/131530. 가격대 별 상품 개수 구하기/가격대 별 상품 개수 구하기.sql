with price as (
    select PRODUCT_ID, PRICE, floor(PRICE / 10000) * 10000 as PRICE_GROUP
    from PRODUCT
)

select PRICE_GROUP, count(*) PRODUCTS
from price
group by PRICE_GROUP
order by PRICE_GROUP