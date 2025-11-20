# Write your MySQL query statement below


with act as(
    select activity_date as day,user_id
    from activity
    where activity_date between date_sub('2019-07-27',interval 29 day) and '2019-07-27'
    group by activity_date,user_id
)

select day,count(user_id) as active_users
from act
group by day;