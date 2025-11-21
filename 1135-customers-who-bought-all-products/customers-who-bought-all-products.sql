# Write your MySQL query statement below

with c_count as(
    select customer_id,count(distinct product_key) as p_count
    from customer
    group by customer_id
),

p_total as(
    select count(*) as total from product
)

select c.customer_id
from c_count c,p_total p
where c.p_count=p.total;
