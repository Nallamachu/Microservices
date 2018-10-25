DROP SCHEMA if exists management CASCADE; commit;
create schema if not exists management  AUTHORIZATION  sa;
set schema management;

create sequence if not exists user_seq;

DROP TABLE if exists management.management_user; commit;
create table if not exists management.management_user (
    id long primary key not null,
    email varchar(255),
    password varchar(255),
    status varchar(15),
    primary key (id)
);
commit;