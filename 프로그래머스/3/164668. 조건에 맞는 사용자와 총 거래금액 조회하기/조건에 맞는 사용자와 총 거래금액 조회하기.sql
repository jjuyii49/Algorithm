select ugu.USER_ID, ugu.NICKNAME, sum(PRICE) as "TOTAL_SALES"
from USED_GOODS_BOARD ugb join USED_GOODS_USER ugu
on ugb.WRITER_ID = ugu.USER_ID
where ugb.STATUS = "DONE"
group by ugb.WRITER_ID
having sum(PRICE) >= 700000
order by TOTAL_SALES