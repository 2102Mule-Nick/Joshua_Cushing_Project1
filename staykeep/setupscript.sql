--Create the tables
/*
--The guest table will hold the records of whomever booked the room
CREATE TABLE guest (
    g_id serial primary key not null,
    g_f_name text,
    g_l_name text,
    charge money
);

--The room table holds the rooms. 
--The r_id will also function as the physical room number.
CREATE TABLE room (
    r_id serial primary key not null,
    status text,
    bed_num int,
    bed_size text,
    lux_level text,
    cost_per_night money
);

--The stay table will hold the information for one booking of a single room.
--If a party booka multiple rooms they will be recorded as multiple stays
CREATE TABLE stay (
    stay_id serial primary key not null,
    ch_i_time time,
    ch_i_date date,
    ch_o_time time,
    ch_o_date date,
    g_id int references guest (g_id),
    r_id int references room (r_id)
);

--The rs_order table will hold a single room service order.
CREATE TABLE rs_order (
    order_id serial primary key not null,
    r_id int references room (r_id),
   	order_tot money
);

--The serv_item table will hold the items available for order as room service.
CREATE TABLE serv_item (
    item_id serial primary key not null,
    item_name text,
    price money
);

--The serv_row table will hold the rows of a single room service order.
CREATE TABLE serv_row (
    row_id serial primary key not null,
    item_id int references serv_item(item_id),
   order_id int references rs_order(order_id)
);
*/

--Populate the serv_item table
/*
INSERT INTO serv_item (item_name, price)
VALUES ('Caviar', 50.00);
INSERT INTO serv_item (item_name, price)
VALUES ('Eggs Benedict', 8.50);
INSERT INTO serv_item (item_name, price)
VALUES ('Cheescake', 6.99);
INSERT INTO serv_item (item_name, price)
VALUES ('Baklava', 10.05);
INSERT INTO serv_item (item_name, price)
VALUES ('Fondue Pot', 6.75);
INSERT INTO serv_item (item_name, price)
VALUES ('Croque Monsieur', 7.75);
INSERT INTO serv_item (item_name, price)
VALUES ('Tea Sandwiches Platter', 13.45);
INSERT INTO serv_item (item_name, price)
VALUES ('Beef Wellinngton', 25.05);
INSERT INTO serv_item (item_name, price)
VALUES ('Flavored Seltzer Bottle', 6.75);
INSERT INTO serv_item (item_name, price)
VALUES ('Good Morning Breakfast', 22.99);
INSERT INTO serv_item (item_name, price)
VALUES ('Charcuterie Platter', 10.05);
INSERT INTO serv_item (item_name, price)
VALUES ('Arabian Coffee', 7.25);
INSERT INTO serv_item (item_name, price)
VALUES ('French-Press Coffee', 6.00);
INSERT INTO serv_item (item_name, price)
VALUES ('Nightcap', 4.50);
INSERT INTO serv_item (item_name, price)
VALUES ('Brandy Suite', 16.00);
INSERT INTO serv_item (item_name, price)
VALUES ('Zinfandel Red Wine', 66.74);
INSERT INTO serv_item (item_name, price)
VALUES ('Furmint White Wine', 35.20);
INSERT INTO serv_item (item_name, price)
VALUES ('Italian Dinner Platter', 12.25);
INSERT INTO serv_item (item_name, price)
VALUES ('French Dinner Platter', 12.25);
INSERT INTO serv_item (item_name, price)
VALUES ('Bosnian Dinner Platter', 12.25);
*/

--The room table has a few columns that will always be filled ith pre-set values
--The STATUS column is always 'available', 'booked', or 'maintenance'
--The BED_SIZE column is always 'single' or 'double'
--The LUX_LEVEL column is always 'standard' or 'luxury'
/*
--12 standard single rooms. Sleeps 1 person in 1 single bed
--1
INSERT INTO room (status, bed_num, bed_size, lux_level, cost_per_night)
VALUES ('available', 1, 'single', 'standard', 100.00);
--2
INSERT INTO room (status, bed_num, bed_size, lux_level, cost_per_night)
VALUES ('available', 1, 'single', 'standard', 100.00);
--3
INSERT INTO room (status, bed_num, bed_size, lux_level, cost_per_night)
VALUES ('available', 1, 'single', 'standard', 100.00);
--4
INSERT INTO room (status, bed_num, bed_size, lux_level, cost_per_night)
VALUES ('available', 1, 'single', 'standard', 100.00);
--5
INSERT INTO room (status, bed_num, bed_size, lux_level, cost_per_night)
VALUES ('available', 1, 'single', 'standard', 100.00);
--6
INSERT INTO room (status, bed_num, bed_size, lux_level, cost_per_night)
VALUES ('available', 1, 'single', 'standard', 100.00);
--7
INSERT INTO room (status, bed_num, bed_size, lux_level, cost_per_night)
VALUES ('available', 1, 'single', 'standard', 100.00);
--8
INSERT INTO room (status, bed_num, bed_size, lux_level, cost_per_night)
VALUES ('available', 1, 'single', 'standard', 100.00);
--9
INSERT INTO room (status, bed_num, bed_size, lux_level, cost_per_night)
VALUES ('available', 1, 'single', 'standard', 100.00);
--10
INSERT INTO room (status, bed_num, bed_size, lux_level, cost_per_night)
VALUES ('available', 1, 'single', 'standard', 100.00);
--11
INSERT INTO room (status, bed_num, bed_size, lux_level, cost_per_night)
VALUES ('available', 1, 'single', 'standard', 100.00);
--12
INSERT INTO room (status, bed_num, bed_size, lux_level, cost_per_night)
VALUES ('available', 1, 'single', 'standard', 100.00);
-- Then 4 of the same but luxury
--1
INSERT INTO room (status, bed_num, bed_size, lux_level, cost_per_night)
VALUES ('available', 1, 'single', 'luxury', 400.00);
--2
INSERT INTO room (status, bed_num, bed_size, lux_level, cost_per_night)
VALUES ('available', 1, 'single', 'luxury', 400.00);
--3
INSERT INTO room (status, bed_num, bed_size, lux_level, cost_per_night)
VALUES ('available', 1, 'single', 'luxury', 400.00);
--4
INSERT INTO room (status, bed_num, bed_size, lux_level, cost_per_night)
VALUES ('available', 1, 'single', 'luxury', 400.00);

--12 regular double rooms. Sleeps 2 people in 2 single person beds.
--1
INSERT INTO room (status, bed_num, bed_size, lux_level, cost_per_night)
VALUES ('available', 2, 'single', 'standard', 200.00);
--2
INSERT INTO room (status, bed_num, bed_size, lux_level, cost_per_night)
VALUES ('available', 2, 'single', 'standard', 200.00);
--3
INSERT INTO room (status, bed_num, bed_size, lux_level, cost_per_night)
VALUES ('available', 2, 'single', 'standard', 200.00);
--4
INSERT INTO room (status, bed_num, bed_size, lux_level, cost_per_night)
VALUES ('available', 2, 'single', 'standard', 200.00);
--5
INSERT INTO room (status, bed_num, bed_size, lux_level, cost_per_night)
VALUES ('available', 2, 'single', 'standard', 200.00);
--6
INSERT INTO room (status, bed_num, bed_size, lux_level, cost_per_night)
VALUES ('available', 2, 'single', 'standard', 200.00);
--7
INSERT INTO room (status, bed_num, bed_size, lux_level, cost_per_night)
VALUES ('available', 2, 'single', 'standard', 200.00);
--8
INSERT INTO room (status, bed_num, bed_size, lux_level, cost_per_night)
VALUES ('available', 2, 'single', 'standard', 200.00);
--9
INSERT INTO room (status, bed_num, bed_size, lux_level, cost_per_night)
VALUES ('available', 2, 'single', 'standard', 200.00);
--10
INSERT INTO room (status, bed_num, bed_size, lux_level, cost_per_night)
VALUES ('available', 2, 'single', 'standard', 200.00);
--11
INSERT INTO room (status, bed_num, bed_size, lux_level, cost_per_night)
VALUES ('available', 2, 'single', 'standard', 200.00);
--12
INSERT INTO room (status, bed_num, bed_size, lux_level, cost_per_night)
VALUES ('available', 2, 'single', 'standard', 200.00);
--4 more of the same but luxury
--1
INSERT INTO room (status, bed_num, bed_size, lux_level, cost_per_night)
VALUES ('available', 2, 'single', 'luxury', 600.00);
--2
INSERT INTO room (status, bed_num, bed_size, lux_level, cost_per_night)
VALUES ('available', 2, 'single', 'luxury', 600.00);
--3
INSERT INTO room (status, bed_num, bed_size, lux_level, cost_per_night)
VALUES ('available', 2, 'single', 'luxury', 600.00);
--4
INSERT INTO room (status, bed_num, bed_size, lux_level, cost_per_night)
VALUES ('available', 2, 'single', 'luxury', 600.00);


--12 regular couple rooms. Sleeps 2 people in 1 double person beds.
--1
INSERT INTO room (status, bed_num, bed_size, lux_level, cost_per_night)
VALUES ('available', 1, 'double', 'standard', 150.00);
--2
INSERT INTO room (status, bed_num, bed_size, lux_level, cost_per_night)
VALUES ('available', 1, 'double', 'standard', 150.00);
--3
INSERT INTO room (status, bed_num, bed_size, lux_level, cost_per_night)
VALUES ('available', 1, 'double', 'standard', 150.00);
--4
INSERT INTO room (status, bed_num, bed_size, lux_level, cost_per_night)
VALUES ('available', 1, 'double', 'standard', 150.00);
--5
INSERT INTO room (status, bed_num, bed_size, lux_level, cost_per_night)
VALUES ('available', 1, 'double', 'standard', 150.00);
--6
INSERT INTO room (status, bed_num, bed_size, lux_level, cost_per_night)
VALUES ('available', 1, 'double', 'standard', 150.00);
--7
INSERT INTO room (status, bed_num, bed_size, lux_level, cost_per_night)
VALUES ('available', 1, 'double', 'standard', 150.00);
--8
INSERT INTO room (status, bed_num, bed_size, lux_level, cost_per_night)
VALUES ('available', 1, 'double', 'standard', 150.00);
--9
INSERT INTO room (status, bed_num, bed_size, lux_level, cost_per_night)
VALUES ('available', 1, 'double', 'standard', 150.00);
--10
INSERT INTO room (status, bed_num, bed_size, lux_level, cost_per_night)
VALUES ('available', 1, 'double', 'standard', 150.00);
--11
INSERT INTO room (status, bed_num, bed_size, lux_level, cost_per_night)
VALUES ('available', 1, 'double', 'standard', 150.00);
--12
INSERT INTO room (status, bed_num, bed_size, lux_level, cost_per_night)
VALUES ('available', 1, 'double', 'standard', 150.00);
--6 more of the same but luxury
--1
INSERT INTO room (status, bed_num, bed_size, lux_level, cost_per_night)
VALUES ('available', 1, 'double', 'luxury', 550.00);
--2
INSERT INTO room (status, bed_num, bed_size, lux_level, cost_per_night)
VALUES ('available', 1, 'double', 'luxury', 550.00);
--3
INSERT INTO room (status, bed_num, bed_size, lux_level, cost_per_night)
VALUES ('available', 1, 'double', 'luxury', 550.00);
--4
INSERT INTO room (status, bed_num, bed_size, lux_level, cost_per_night)
VALUES ('available', 1, 'double', 'luxury', 550.00);
--5
INSERT INTO room (status, bed_num, bed_size, lux_level, cost_per_night)
VALUES ('available', 1, 'double', 'luxury', 550.00);
--6
INSERT INTO room (status, bed_num, bed_size, lux_level, cost_per_night)
VALUES ('available', 1, 'double', 'luxury', 550.00);

--4 family rooms. Sleeps 4 people in 2 double beds.
--1
INSERT INTO room (status, bed_num, bed_size, lux_level, cost_per_night)
VALUES ('available', 2, 'double', 'standard', 400.00);
--2
INSERT INTO room (status, bed_num, bed_size, lux_level, cost_per_night)
VALUES ('available', 2, 'double', 'standard', 400.00);
--3
INSERT INTO room (status, bed_num, bed_size, lux_level, cost_per_night)
VALUES ('available', 2, 'double', 'standard', 400.00);
--4
INSERT INTO room (status, bed_num, bed_size, lux_level, cost_per_night)
VALUES ('available', 2, 'double', 'standard', 400.00);
--2 more of the same but luxury
--1
INSERT INTO room (status, bed_num, bed_size, lux_level, cost_per_night)
VALUES ('available', 2, 'double', 'luxury', 700.00);
--2
INSERT INTO room (status, bed_num, bed_size, lux_level, cost_per_night)
VALUES ('available', 2, 'double', 'luxury', 700.00);
*/