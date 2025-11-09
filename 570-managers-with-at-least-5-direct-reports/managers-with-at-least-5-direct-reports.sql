# Write your MySQL query statement below
select name 
from employee e 
join
(
    select managerid from employee where managerid is not null group by managerid having count(managerid)>=5
) m on e.id=m.managerid