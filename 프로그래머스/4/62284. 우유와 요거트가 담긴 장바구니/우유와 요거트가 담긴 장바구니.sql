with yogurt as (
    select CART_ID
    from CART_PRODUCTS
    where NAME = 'Yogurt'
),

milk as (
    select CART_ID
    from CART_PRODUCTS
    where NAME = 'Milk'
)

select y.CART_ID
from yogurt y join milk m
on y.CART_ID = m.CART_ID
order by CART_ID