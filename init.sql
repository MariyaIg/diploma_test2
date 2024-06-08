drop table ratings;
drop table users;
drop table accounts;
drop table accounts_template;
drop table companies;
drop table industries;


create table if not exists industries (id serial primary key, title varchar(500), code varchar (30),risk integer);
create table if not exists users (id serial primary key, name varchar (250), login varchar (30), password varchar (30));
create table if not exists companies (id serial primary key, taxId varchar (30), title varchar(250), industry_id integer, foreign key (industry_id) References industries(id));
create table if not exists ratings (id serial primary key, date varchar(30), company_id integer, foreign key (company_id) References companies(id) on delete cascade, financial_score integer, total_score integer, user_id integer, foreign key (user_id) References users(id) on delete set null,calculation_date date);
create table if not exists accounts (id serial primary key, date varchar(30),company_id integer, foreign key (company_id) References companies(id) ON DELETE CASCADE,
    sales bigint, operating_profit bigint, net_profit bigint, current_assets bigint, current_liabilities bigint, equity bigint, st_debt bigint , lt_debt bigint, tbs bigint);
create table if not exists accounts_template (id serial primary key, date varchar(30),company_id integer, foreign key (company_id) References companies(id) ON DELETE CASCADE,
    sales bigint, sales_2 bigint, operating_profit bigint, net_profit bigint, current_assets bigint, current_liabilities bigint, equity bigint, st_debt bigint , lt_debt bigint, tbs bigint);

insert into users (name, login, password) values ('admin','admin','admin');



