# Write your MySQL query statement below
with cte as(
    select u.product_id,
    sum(u.units*p.price) as total_price,
    sum(u.units) as total_units
    from unitssold u
    join
    prices p on u.product_id=p.product_id
    and u.purchase_date between p.start_date and p.end_date
    group  by u.product_id
)


select p.product_id,
round(ifnull(c.total_price/c.total_units,0),2) as average_price from prices p left join cte c on p.product_id =c.product_id group by p.product_id;