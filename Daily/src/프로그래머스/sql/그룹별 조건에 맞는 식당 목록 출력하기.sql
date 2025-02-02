
with temp as (
    select member_id id, count(*) cnt
        from rest_review
    group by member_id
    order by cnt desc limit 1
)

select m.member_name,
       r.review_text,
       date_format(r.review_date, '%Y-%m-%d') review_date
    from member_profile m
         inner join rest_review r
                    on m.member_id = r.member_id
    where m.member_id = (select id from temp)
    order by 3, 2
