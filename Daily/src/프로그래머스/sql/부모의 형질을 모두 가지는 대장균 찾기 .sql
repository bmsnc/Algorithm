
select e.id, e.genotype, p.genotype as parent_genotype
from ECOLI_DATA e inner join ECOLI_DATA p
                     on e.parent_id = p.id
where 1=1
  and e.genotype & p.genotype = p.genotype
order by e.id;