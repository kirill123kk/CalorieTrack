create table if not exists dish
(
    id                         varchar not null
    primary key,
    name                       varchar not null,
    calorie                    int  not null,
    proteins                   real not null,
    fats                       real not null,
    carbohydrates              real not null
);