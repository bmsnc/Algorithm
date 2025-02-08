
with temp as (
    select cart_id
    from cart_products p1 where p1.name = 'Milk'
)

select distinct cart_id
    from cart_products p
where 1=1
    and p.name = 'Yogurt'
    and cart_id in (select t.cart_id from temp t)
order by cart_id

-- SELECT CART_ID
--     FROM CART_PRODUCTS
-- WHERE NAME IN ('Yogurt', 'Milk')
--     GROUP BY CART_ID
--     HAVING COUNT(DISTINCT NAME) >= 2
-- ORDER BY CART_ID ASC