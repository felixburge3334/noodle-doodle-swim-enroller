/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  mood35-Laptop
 */
DROP TABLE TSDB;

CREATE TABLE TSDB (
    TSID int GENERATED ALWAYS AS IDENTITY NOT NULL,
    TSName varchar(128) NOT NULL,
    TSAddress varchar(128) NOT NULL,
    TSType varchar(128),
    TSEmail varchar(128),
    TSStatus int,
    PRIMARY KEY(TSID)
);

insert into tsdb(TSname, TSAddress,TSType, TSEmail, TSStatus)
Values 
('UNIBITZ', 'U13 Featherweight Avenue, Springfield, NSW, 2630', 'TEACHER', 'unibitzservice@gmail.com', 1),
('Trial1', 'U17 Featherweight Avenue, Springfield, NSW, 2630', 'STUFF', 'trial1@trial1.com',0);
('Trial2', 'U18 Feaht Street, Jenkins, NSW, 2888', 'TEACHER', 'trial2@trial1.com',0);

select * from TSDB;