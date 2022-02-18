create table users(
     id bigint not null primary key ,
     username varchar(50) not null,
     email varchar(50),
     password text not null
);
insert into users(id, username, email, password) values (1, 'admin', 'admin@admin.com', '$2y$12$rnZ4zWxhPv.7iSOhBKkGqu2PVsJf./W78TScYJd.EWdaEeWhnhQW.');