
select
        sum(g.score) score,
        g.emp_no emp_no,
        e.emp_name emp_name,
        e.position position,
        e.email email
    from hr_grade g join hr_employees e
        on g.emp_no = e.emp_no
    where g.year = '2022'
        group by (g.emp_no)
        order by score desc
    limit 1;