
select count(*) fish_count
from fish_info f
where year(f.time) = '2021';