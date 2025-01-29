
-- with second as (
--     select e.id
--         from ecoli_data e
--     where parent_id in (select id from ecoli_data where parent_id is null)
-- )

select id
    from ecoli_data
    where parent_id in (
       select e.id
        from ecoli_data e
        where parent_id in (select id from ecoli_data where parent_id is null)
    )
order by 1