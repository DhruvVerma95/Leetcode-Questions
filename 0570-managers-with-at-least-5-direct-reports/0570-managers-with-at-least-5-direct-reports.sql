# Write your MySQL query statement below
Select name from Employee WHERE id IN ( Select managerId from Employee WHERE managerId IS NOT NULL GROUP BY managerId HAVING COUNT(*) >= 5 );