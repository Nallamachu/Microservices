DROP SCHEMA if exists FIRM CASCADE; commit;
create schema if not exists FIRM  AUTHORIZATION  sa;
set schema FIRM;
create sequence if not exists firm_seq;

DROP TABLE if exists FIRM.FIRM; commit;
create table if not exists FIRM.FIRM (
    id long primary key not null,
    year long not null,
    amount long not null,
    primary key (id)
);
commit;