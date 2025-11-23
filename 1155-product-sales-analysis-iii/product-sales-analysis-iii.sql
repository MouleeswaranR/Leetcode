# Write your MySQL query statement below
with FirstYearSales as(
    select product_id,
    min(year) as first_year
    from sales
    group by product_id 
)

select s.product_id,f.first_year,s.quantity,s.price
from FirstYearSales f
join sales s  on s.product_id=f.product_id and f.first_year=s.year;