DROP TABLE EVENT;

CREATE TABLE EVENT
(
Event_ID int GENERATED ALWAYS AS IDENTITY NOT NULL,
Event_Name varchar (128),
Event_Date DATE,
Event_Description varchar (128),
Event_Visibility boolean,


PRIMARY KEY(Event_ID)
);

INSERT INTO EVENT(Event_Name,Event_Date,Event_Description,Event_Visibility) 
VALUES('Show Case',10/26/2000,'Show Case Assignment 3 - Release 2', TRUE);

INSERT INTO EVENT(Event_Name,Event_Date,Event_Description,Event_Visibility) 
VALUES('Meeting',10/26/2000,'Meetings for the subject Advanced Software Development', TRUE);

SELECT * FROM EVENT;