create table if not exists meal
(
    id                         varchar not null
    primary key,
    name                       varchar not null,
    user_id                    varchar not null,
    date_time                  timestamp
);