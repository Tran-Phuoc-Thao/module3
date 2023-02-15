INSERT INTO Class
VALUES (1, 'A1', '2008-12-20', 1);
INSERT INTO Class
VALUES (2, 'A2', '2008-12-22', 1);
INSERT INTO Class
VALUES (3, 'B3', current_date, 0);
INSERT INTO Student (StudentID,StudentName, Address, Phone, Status, ClassID)
VALUES (1,'Hung', 'Ha Noi', '0912113113', 1, 1),
(2,'Hoa', 'Hai phong',null, 1, 1),
(3,'Manh', 'HCM',' 0123123123', 0, 2);
INSERT INTO Subject
VALUES (1, 'CF', 5, 1),
       (2, 'C', 6, 1),
       (3, 'HDJ', 5, 1),
       (4, 'RDBMS', 10, 1);
create table Mark(
MarkID int Primary key,
SubID int,
StudentID int,
Mark int,
ExamTimes int
);
Alter table Mark
add constraint fk_mark_subid
foreign key(SubID)
references subject(SubId);
create table Student(
StudentID int Primary key,
StudentName char(200),
Address char(200),
Phone char(20),
Status int,
ClassID int
);
Alter table student
add constraint fk_student_classid
foreign key(ClassID)
references class(ClassID);
INSERT INTO mark (MarkID,SubID, StudentID, Mark, ExamTimes)
VALUES (1,1, 1, 8, 1),
       (2,1, 2, 10, 2),
       (3,2, 1, 12, 1);
-- cau 1
select * 
from student
where StudentName like 'H%';
-- cau 2
select *
from class
where month(startDate) = 12;
-- cau 3
SELECT * FROM `subject` WHERE Credit BETWEEN 3 AND 5;
-- cau 4
UPDATE student SET classId = 2 WHERE StudentName = 'Hung';
-- cau 5
SELECT student.StudentName, subject.SubName, mark.Mark FROM student, mark, subject
ORDER BY mark.Mark ASC, student.StudentName DESC;
