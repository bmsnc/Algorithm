
select round(avg(ifnull(i.length, 10)),2) average_length
    from fish_info i;
