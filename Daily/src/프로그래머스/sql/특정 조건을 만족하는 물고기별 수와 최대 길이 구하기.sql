
select count(id) fish_count,
       max(i.length) max_length,
       i.fish_type fish_type
from fish_info i
    group by i.fish_type
        having avg(
               case
                   when i.length <= 10 then 10
                   when i.length is null then 10
                   else i.length
                   end ) >= 33
order by 3;
