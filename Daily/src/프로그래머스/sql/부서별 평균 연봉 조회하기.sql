

  select d.dept_id dept_id,
       d.dept_name_en dept_name_en,
       round(avg(e.sal)) avg_sal
      from hr_department d inner join hr_employees e
                    on d.dept_id = e.dept_id
      group by d.dept_id
    order by 3 desc