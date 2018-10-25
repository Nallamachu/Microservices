DROP SCHEMA if exists AUM CASCADE; commit;
create schema if not exists AUM  AUTHORIZATION  sa;
set schema AUM;

create sequence if not exists asset_seq;
--DESCRETIONARY value 1 is DESCRETIONARY and 2 is NON-DESCRETIONARY
DROP TABLE if exists AUM.ASSETS; commit;
create table if not exists AUM.ASSETS (
    id long primary key not null,
    year long not null,
    amount long not null,
    DESCRETIONARY long,
    primary key (id)
);
commit;