
select rnk_info.id, fish_name_info.fish_name, rnk_info.length
    from
        (select *,
            rank() over(partition by fish_type order by length desc)  rnk
            from fish_info) rnk_info
                join fish_name_info
             on rnk_info.fish_type = fish_name_info.fish_type
    where rnk = 1
    order by 1