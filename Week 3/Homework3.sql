create database homework3;
use homework3;

create table customer(
    cus_code int, 
    cus_lname varchar(20), 
    cus_fname varchar(20), 
    cus_initial char, 
    cus_areacode int, 
    cus_phone int, 
    primary key(cus_code));

create table invoice(
    inv_number int, 
    cus_code int, 
    inv_date date, 
    primary key(inv_number), 
    foreign key(cus_code) references customer(cus_code));

create table vendor(
    vend_code int, 
    vend_name varchar(30), 
    vend_contact varchar(30), 
    vend_areacode int, 
    vend_phone int, 
    primary key(vend_code));

create table product(
    prod_code int, 
    prod_desc varchar(50), 
    prod_price int, 
    prod_quant int, 
    vend_code int, 
    primary key(prod_code), 
    foreign key(vend_code) references vendor(vend_code));

create table line(
    inv_number int, 
    prod_code int, 
    line_units int, 
    primary key(inv_number, prod_code), 
    foreign key(inv_number) references invoice(inv_number), 
    foreign key(prod_code) references product(prod_code));


insert into customer values (10010, "Ramas", "Alfred", 'A', 615, 8442573);
insert into customer values (10011, "Dunne", "Leona", 'K', 713, 8941238);
insert into customer values (10012, "Smith", "Kathy", 'W', 615, 8942285);
insert into customer values (10013, "Olowski", "Paul", 'F', 615, 2221672);
insert into customer values (10014, "Orlando", "Myron", NULL, 615, 2971228);

insert into invoice values (1001, 10011, '2008-08-03');
insert into invoice values (1002, 10014, '2008-08-04');
insert into invoice values (1003, 10012, '2008-03-20');
insert into invoice values (1004, 10011, '2008-09-23');

insert into vendor values (232, "Bryson", "Smith", 615, 2233234);
insert into vendor values (235, "SuperLoo", "Anderson", 615, 2158995);

insert into product values (12321, "hammer", 189 ,20, 232);
insert into product values (65781, "chain", 12, 45, 235);
insert into product values (34256, "tape", 35, 60, 235);
insert into product values (12333, "hanger", 200 ,10, 232);

insert into line values (1001, 12321, 1);
insert into line values (1001, 65781, 3);
insert into line values (1002, 34256, 6);
insert into line values (1003, 12321, 5);
insert into line values (1002, 12333, 6);