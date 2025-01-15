with sorted_data as (
    select ID, row_number() over(order by SIZE_OF_COLONY desc) as rn, count(*) over() as total
    from ECOLI_DATA
)

select ID, case when rn <= total * 0.25 then 'CRITICAL'
                when rn <= total * 0.5 then 'HIGH'
                when rn <= total * 0.75 then 'MEDIUM'
                else 'LOW' end as COLONY_NAME
from sorted_data
order by ID