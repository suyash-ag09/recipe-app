create table if not exists recipe (
    id bigint not null,
    category varchar(255),
    description varchar(255),
    label varchar(255),
    name varchar(255),
    price double,
    primary key (id));