create table if not exists industries (id serial primary key, title varchar(250), code real,risk integer);
create table if not exists users (id serial primary key, name varchar (250), login varchar (30), password varchar (30));
create table if not exists companies (id serial primary key, taxId varchar (30), title varchar(250), industry_id integer, foreign key (industry_id) References industries(id));
create table if not exists ratings (id serial primary key, date varchar(30), company_id integer, foreign key (company_id) References companies(id), score integer, user_id integer, foreign key (user_id) References users(id),calculation_date date);
create table if not exists accounts (id serial primary key, date varchar(30),company_id integer, foreign key (company_id) References companies(id) ON DELETE CASCADE,
    sales bigint, operating_profit bigint, net_profit bigint, current_assets bigint, current_liabilities bigint, equity bigint, st_debt bigint , lt_debt bigint, tbs bigint);










Insert into industries (title, code) values ('Торговля автотранспортными средствами', 45.11);
    insert into industries (title, code) values ('Деятельность агентов по оптовой торговле сельскохозяйственным сырьем, живыми животными, текстильным сырьем и полуфабрикатами', 46.11);
    insert into industries (title, code) values ('Торговля оптовая автомобильными деталями, узлами и принадлежностями', 45.31);
    insert into industries (title, code) values ('Добыча и обогащение угля', 05.10);
    insert into industries (title, code) values ('Переработка и консервирование мяса', 10.11);
    delete from industries where id=5;
    update users set password  = 'zzz' where login = 'Petrov';
    select*from accounts join public.companies c on c.id = accounts.company_id where date='2023-12-31' and taxid ='0501'
    ALTER TABLE accounts
    DROP CONSTRAINT company_id,
    ADD CONSTRAINT company_id
    FOREIGN KEY (company_id)
    REFERENCES companies(id)
                                                 ON DELETE CASCADE;
    insert into ratings (date, company_id, score, user_id) values ('2023-12-25',16,55,1);
    ALTER TABLE ratings
    DROP CONSTRAINT company_id,
    ADD CONSTRAINT company_id
    FOREIGN KEY (company_id)
    REFERENCES companies(id)
                                                 ON DELETE CASCADE;
    select*from accounts join public.companies c on c.id = accounts.company_id where date ='2022-12-31'and taxId ='111'
