
select sum(i.price) total_price
    from item_info i
where i.rarity = 'LEGEND';