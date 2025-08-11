# Write your MySQL query statement below
select w.id from Weather w join Weather c 
where datediff(w.recordDate,c.recordDate)=1 
AND 
w.temperature > c.temperature;