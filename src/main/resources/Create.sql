create table admin_login(
email varchar2(50) unique,
password varchar2(


create table booklist( 
   ISBN number  primary key,
    book_name varchar2(100)not null,
   pages number not null,
   author_name varchar2(100) not null, 
   publication varchar2(100),
   released_date date ,
   price number,
   category varchar2(50),
   book_status varchar2(100) default 'Available',
   rack_no number not null,
   constraints book_status check(book_status in ('Available','Notavailable')),
   constraints pages_num check(pages>0),
   constraint price_pri check (price>=0)
   );
   
   
   create table student(
   student_id number primary key,
   student_name varchar2(50),
   dept_name varchar2(40),
   mail_id varchar2(100)unique
   );
   

    create table book_summary(
   student_id number ,
   ISBN number unique ,
   borrowed_date  date not null,
   renewal_count number default 0,
   due_date date not null,
   return_date date ,
   status varchar2(30) default 'Notreturned',
   constraint renewal_count_cq check (renewal_count<=2),
   constraints status check(status in ('Returned','Notreturned')),
   constraint student_id_FK foreign key(student_id) references  student(student_id),
  constraint ISBN_fw foreign key(ISBN) references booklist(ISBN)
   );
  
   
   
    create table fine_amount(
  student_id  number,
  ISBN number ,  
  fines_per_day number ,
  no_of_extra_days number default 0,
  fines number default 0,
   constraint student_id_pq foreign key(student_id) references student (student_id),
   constraint ISBN_kq foreign key(ISBN) references  booklist(ISBN)
  );
  alter table fine_amount
 add fine_status varchar2(40) default 'unpaid'
 add lost_penality number default 0
 
 
 create table amount(
student_id number unique ,
amount_in_id number,
library_wallet number
);


declare
lib_wallet number;
begin
LIB_WALLET_PROC(lib_wallet);
DBMS_OUTPUT.PUT_LINE(lib_wallet);
end;

 
 
 
 
 
  
  
  
  