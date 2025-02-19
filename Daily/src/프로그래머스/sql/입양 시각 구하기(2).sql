
with recursive temp as (
    select 0 hour
        union all
    select hour + 1
        from temp
        where hour < 23
)

select hour, count(hour(a.datetime)) count
    from temp t left join animal_outs a
        on t.hour = hour(a.datetime)
    group by t.hour
order by hour