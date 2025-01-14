
select count(*) fish_count, (month(i.time)) month
    from fish_info i
group by(month(i.time))
order by 2;