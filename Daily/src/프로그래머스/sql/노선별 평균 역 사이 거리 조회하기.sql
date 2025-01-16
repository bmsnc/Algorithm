
select d.route,
       concat(round(sum(d.d_between_dist), 1), 'km') total_distance,
       concat(round(avg(d.d_between_dist), 2), 'km') average_distance
from subway_distance d
group by(d.route)
order by sum(d.d_between_dist) desc;