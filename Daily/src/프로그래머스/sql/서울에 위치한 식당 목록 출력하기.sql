
select  i.rest_id,
        i.rest_name,
        i.food_type,
        i.favorites,
        i.address,
        round(avg(r.review_score), 2) score
        from rest_info i join rest_review r
                  on i.rest_id = r.rest_id
    where substring(i.address, 1, 2) = '서울'
        group by r.rest_id
    order by 6 desc, 4 desc;