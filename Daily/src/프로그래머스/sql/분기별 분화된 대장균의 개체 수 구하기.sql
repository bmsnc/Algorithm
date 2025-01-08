
with temp as (
    select id,
           case
               when (month(differentiation_date) between '01' and '03') then '1Q'
               when (month(differentiation_date) between '04' and '06') then '2Q'
               when (month(differentiation_date) between '07' and '09') then '3Q'
               else '4Q'
               end as quarter
    from ecoli_data
)

select t.quarter quarter, count(*) ecoli_count
from temp t
group by (t.quarter)
order by 1;
