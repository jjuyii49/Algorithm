with ITEM_RARE as (select *
    from ITEM_INFO
    where RARITY = "RARE"
)

select ii.ITEM_ID, ii.ITEM_NAME, ii.RARITY
from ITEM_RARE ir join ITEM_TREE it
on it.PARENT_ITEM_ID = ir.ITEM_ID
join ITEM_INFO ii on it.ITEM_ID = ii.ITEM_ID
order by ii.ITEM_ID desc