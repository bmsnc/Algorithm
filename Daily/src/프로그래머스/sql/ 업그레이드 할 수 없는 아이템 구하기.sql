
    select i.item_id item_id,
           i.item_name item_name,
           i.rarity rarity
        from item_info i
    where i.item_id not in (select distinct parent_item_id
                            from item_tree
                            where parent_item_id is not null)
    order by i.item_id desc