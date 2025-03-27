create table if not exists users
(
    id                         varchar not null
    primary key,
    name                       varchar not null,
    email                      varchar not null,
    age                        int  not null,
    weight                     real not null,
    growth                     int not null,
    purpose                    varchar not null,
    daily_value                int not null
    );