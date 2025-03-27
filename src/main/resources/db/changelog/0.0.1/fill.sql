INSERT INTO users (id, name, email, age, weight, growth, purpose, daily_value)
VALUES
    ('a6bbb1d8-36d6-4313-bbb3-8336a4755fd0', 'Григорий', 'Abricos@mail.ru', 30, 88.5, 180,'Loss', 998);

INSERT INTO dish (id, name, calorie, proteins, fats, carbohydrates)
VALUES
    ('4326ce89-85fe-4005-9a5d-ccd2ce623c3b', 'Стейк', 450, 16.8, 15, 20.5);

INSERT INTO meal (id, name, user_id, date_time)
VALUES
    ('335e68e7-54fa-4f09-b7ed-0c53fa47dbd0', 'supper', 'a6bbb1d8-36d6-4313-bbb3-8336a4755fd0', '2025-03-24 12:37:41.550000');

INSERT INTO meal_dish (id, dish_id, meal_id, portion_count)
VALUES
    ('76ebd6cd-5a3a-427f-bb72-b31e25728ccc', '4326ce89-85fe-4005-9a5d-ccd2ce623c3b', '335e68e7-54fa-4f09-b7ed-0c53fa47dbd0', 1);
