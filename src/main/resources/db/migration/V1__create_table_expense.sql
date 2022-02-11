create table expenses (
    id serial not null  primary key,
    description text,
    value money,
    payment_day date
);

insert into expenses (description, "value", payment_day) values ('Expense test', 1000.00, '2022-02-11');
