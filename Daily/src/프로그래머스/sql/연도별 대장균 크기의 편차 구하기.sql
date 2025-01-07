
with maxData as (
    select year(differentiation_date) year , max(size_of_colony) size
from ecoli_data
group by year(differentiation_date)
    )

select
    year(e.differentiation_date) year,
    abs(e.size_of_colony - (select size from maxData m where m.year = year(e.differentiation_date))) year_dev,
    e.id
    from ecoli_data e
order by 1, 2;