with truck_discount as (
    select regexp_replace(DURATION_TYPE, "[^0-9]+", "") as DURATION,
            regexp_replace(DISCOUNT_RATE, "[^0-9]+", "") as DISCOUNT
    from CAR_RENTAL_COMPANY_DISCOUNT_PLAN
    where CAR_TYPE = "트럭"
)

select h.HISTORY_ID, case when DATEDIFF(END_DATE, START_DATE) + 1 >= 90 then c.DAILY_FEE * (DATEDIFF(END_DATE, START_DATE) + 1) * (100 - (select DISCOUNT from truck_discount where DURATION = 90)) / 100
                        when DATEDIFF(END_DATE, START_DATE) + 1 >= 30 then c.DAILY_FEE * (DATEDIFF(END_DATE, START_DATE) + 1) * (100 - (select DISCOUNT from truck_discount where DURATION = 30)) / 100
                        when DATEDIFF(END_DATE, START_DATE) + 1 >= 7 then c.DAILY_FEE * (DATEDIFF(END_DATE, START_DATE) + 1) * (100 - (select DISCOUNT from truck_discount where DURATION = 7)) / 100
                        else c.DAILY_FEE * (DATEDIFF(END_DATE, START_DATE) + 1) end as "FEE"
from CAR_RENTAL_COMPANY_RENTAL_HISTORY h join CAR_RENTAL_COMPANY_CAR c
on h.CAR_ID = c.CAR_ID and CAR_TYPE = "트럭"
order by FEE desc, h.HISTORY_ID desc

