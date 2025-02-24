
select item.item_id, item.item_name, item.rarity
    from item_info item join
         (
             select tree.item_id
             from item_info info
                      join item_tree tree
                           on info.item_id = tree.parent_item_id
             where info.rarity = 'RARE'
         ) sub
     on item.item_id = sub.item_id
order by item.item_id desc