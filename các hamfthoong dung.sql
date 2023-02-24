-- cau 1
select * from subject
where Credit >= All (select Credit from subject);

-- cau 2
select * from subject s inner join mark m on s.subID = m.SubID
where mark >= All(select mark from	mark);

-- cau 3
select s.StudentID,s.StudentName,avg(mark) 
from student s inner join mark m on s.StudentID = m.StudentID
group by s.StudentID,s.StudentName
order by avg(Mark) desc;


