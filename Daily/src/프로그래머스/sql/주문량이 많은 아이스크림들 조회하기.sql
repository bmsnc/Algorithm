
with temp as(
    select flavor, sum(total_order) sum
        from july
    group by flavor
)

select f.flavor
    from first_half f join temp t
               on f.flavor = t.flavor
    order by (f.total_order + t.sum) desc
    limit 3;