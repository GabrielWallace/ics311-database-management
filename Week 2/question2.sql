create database question2;
use question2;
create table Branch(branch_id int, branch_name varchar(25), branch_city varchar(25), assets decimal(13, 4), primary key (branch_id));

create table Customer(customer_id int, customer_name varchar(25), customer_street varchar(25), customer_city varchar(25), primary key (customer_id));

create table Loan(loan_number int, branch_id int, amount decimal(13, 4), primary key (loan_number) ,foreign key (branch_id) references Branch(branch_id));

create table Borrower(customer_id int, loan_number int, primary key (customer_id, loan_number), foreign key (customer_id) references Customer(customer_id), foreign key (loan_number) references Loan(loan_number));

create table Account(account_number int, branch_id int, balance decimal(13, 4), primary key (account_number), foreign key (branch_id) references Branch(branch_id));

create table Depositor(customer_id int, account_number int, primary key (customer_id, account_number), foreign key (customer_id) references Customer(customer_id), foreign key (account_number) references Account(account_number));

insert into branch values (1, 'First Bank of Ferenginar', 'Tower of Commerce', 912547854.32);
insert into branch values (2, 'Bank of Andor', 'Laikan', 19025465.23);
insert into branch values (3, 'Bank of Bolis', 'Bole', 57954895.23);


insert into customer values (10001, 'William Riker', '#1 1st street' , 'Anchorage');
insert into customer values (10002, 'Quark', '285 Capitalism Way' , 'Tower of Commerce');
insert into customer values (10003, 'James T. Kirk', '51 W. 1st St' , 'Riverside');

insert into loan values (15498, 1, 150000.00);
insert into loan values (89541, 2, 23658.00);
insert into loan values (98542, 3, 1254874.00);

insert into borrower values (10001, 15498);
insert into borrower values (10002, 89541);
insert into borrower values (10003, 98542);

insert into account values (12345, 1, 455879.23);
insert into account values (65848, 2, 8965741.89);
insert into account values (96518, 3, 788954174.32);

insert into depositor values (10001, 12345);
insert into depositor values (10002, 65848);
insert into depositor values (10003, 96518);
