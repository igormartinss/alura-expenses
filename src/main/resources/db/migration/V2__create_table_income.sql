create table incomes (
    id serial not null  primary key,
    description text,
    value money,
    payment_day date
);

insert into incomes (description, value, payment_day) values ('Income test', 1000.00, '2022/02/11');