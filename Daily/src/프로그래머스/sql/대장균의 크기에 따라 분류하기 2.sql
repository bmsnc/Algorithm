
with temp as (
    select id, rank() over(order by size_of_colony desc) ranks
    from ecoli_data
)

select id,
       case
           when(t.ranks / (select count(*) from temp) <= 0.25) then 'CRITICAL'
           when(t.ranks / (select count(*) from temp) <= 0.5) then 'HIGH'
           when(t.ranks / (select count(*) from temp) <= 0.75) then 'MEDIUM'
           else 'LOW'
           end as COLONY_NAME
from temp t
order by t.id ;