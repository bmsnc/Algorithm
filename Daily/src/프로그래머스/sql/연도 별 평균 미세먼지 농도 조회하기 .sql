
select year(p.ym) year,
    round(avg(pm_val1),2) pm10,
    round(avg(pm_val2),2) 'pm2.5'
from air_pollution p
    where p.location2 = '수원'
    group by year(p.ym)
    order by 1;