
with temp as (
    select emp_no,
           avg(score) score,
           case
               when (avg(score) >= 96) then 'S'
               when (avg(score) >= 90) then 'A'
               when (avg(score) >= 80) then 'B'
               else 'C'
           end as grade
    from hr_grade
    group by emp_no
)

select e.emp_no,
       e.emp_name,
       t.grade,
       case
           when (t.grade = 'S') then e.sal * 0.2
           when (t.grade = 'A') then e.sal * 0.15
           when (t.grade = 'B') then e.sal * 0.1
           else 0
       end bonus
from hr_employees e join temp t
         on e.emp_no = t.emp_no
order by emp_no