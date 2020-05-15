insert into user_f (USER_ID,CONTACT_NO,EMAIL_ID,USER_NAME,USER_PASSWORD,USER_ROLE)values('u101',1234567890,'janhavisingh0298@gmail.com','Janhavi singh','jan1234','user');        

insert into appointment_f(APPOINTMENT_ID,CENTER_ID,DATE_TIME,TEST_ID,USER_ID)values (103,'c101','04-JUN-20 10:34:09.000','t101','u101');
  
insert into test_f (TEST_ID,CENTER_ID,TEST_NAME) values ('t101','c101','Malaria');
 
insert into diagnostic_center_f (CENTER_ID,ADDRESS,CENTER_NAME,CONTACT_NO) values ('c101','gujaini','XYZ',12345674);
  
insert into user_f (USER_ID,CONTACT_NO,EMAIL_ID,USER_NAME,USER_PASSWORD,USER_ROLE)values('u102',1234567890,'capgdemo@gmail.com','capgemini','capg1234','user');        

insert into user_f (USER_ID,CONTACT_NO,EMAIL_ID,USER_NAME,USER_PASSWORD,USER_ROLE)values('u103',1234567890,'lavikatiyar941@gmail.com','Lavi Katiayar','lavi1234','user');        

insert into diagnostic_center_f (CENTER_ID,ADDRESS,CENTER_NAME,CONTACT_NO) values ('c102','Barra','ABC',259475674);

insert into test_f (TEST_ID,CENTER_ID,TEST_NAME) values ('t102','c102','Malaria');

insert into test_f (TEST_ID,CENTER_ID,TEST_NAME) values ('t103','c101','Corona');

insert into appointment_f(APPOINTMENT_ID,CENTER_ID,DATE_TIME,TEST_ID,USER_ID) values (105,'c101','08-JAN-20 10:34:09.000','t102','u103');

insert into appointment_f(APPOINTMENT_ID,CENTER_ID,DATE_TIME,TEST_ID,USER_ID)values (104,'c101','08-JUL-20 10:34:09.000','t102','u102');

insert into appointment_f(APPOINTMENT_ID,CENTER_ID,DATE_TIME,TEST_ID,USER_ID)values (102,'c101','05-AUG-20 10:34:09.000','t103','u102');

insert into appointment_f(APPOINTMENT_ID,CENTER_ID,DATE_TIME,TEST_ID,USER_ID) values (101,'c102','08-AUG-20 10:34:09.000','t103','u103');

select * from user_f;

select * from APPOINTMENT_F;

select * from diagnostic_center_f;

select * from test_f;



