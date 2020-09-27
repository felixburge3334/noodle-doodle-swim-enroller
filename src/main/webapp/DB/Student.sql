DROP TABLE STUDENT;

CREATE TABLE STUDENT
(
Student_ID int GENERATED ALWAYS AS IDENTITY NOT NULL,
Full_Name varchar (128),
DOB DATE,
Email varchar (128),
Address varchar (255),
Phone int,
Title varchar (5),
Password varchar (128),


PRIMARY KEY(Student_ID)
);

INSERT INTO STUDENT(Full_Name,DOB,Email,Address,Phone,Title,Password) 
VALUES('Grady','01/01/2000','Grady@grady.com', '1 grady st, Melbourne',0411111111,'Mr','grady');

INSERT INTO STUDENT(Full_Name,DOB,Email,Address,Phone,Title,Password) 
VALUES('Apple','02/02/2000','A@a.com', 'a st, A',0422222222,'Mr','a');

SELECT * FROM STUDENT;