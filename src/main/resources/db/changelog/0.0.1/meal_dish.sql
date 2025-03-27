create table if not exists meal_dish
(
    id                         varchar not null
    primary key,
    dish_id                    varchar not null,
    meal_id                    varchar not null,
    portion_count              real not null,
    foreign key (meal_id) references meal (id) on delete cascade,
    foreign key (dish_id) references dish (id) on delete cascade
);