
with temp as (
    select info.user_id, sale.online_sale_id, sale.sales_amount, sale.sales_date
    from (select *
            from user_info
          where year(joined) = 2021) info
             left join online_sale sale
               on info.user_id = sale.user_id
        )

    select year(sales_date) year,
            month(sales_date) month,
            count(distinct user_id) purchased_users,
            round(count(distinct user_id) /(select count(distinct user_id) from temp),2) puchased_ratio
        from temp
    where online_sale_id is not null
        group by year(sales_date), month(sales_date)
        order by year, month
