
-- 풀이 1
select count(i.fish_type) fish_count,
       (select fish_name
        from fish_name_info n
        where n.fish_type = i.fish_type) fish_name
from fish_info i
group by (i.fish_type)
order by 1 desc;

-- 풀이 2
SELECT FI.FISH_COUNT
     , FNI.FISH_NAME
FROM (
         SELECT FI.FISH_TYPE
              , COUNT(*) FISH_COUNT
         FROM FISH_INFO FI
         GROUP BY FI.FISH_TYPE
     ) FI
         LEFT JOIN FISH_NAME_INFO FNI
                   ON FI.FISH_TYPE = FNI.FISH_TYPE
ORDER BY FI.FISH_COUNT DESC