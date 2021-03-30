--<LOTUS HOTEL SETUP SCRIPT>
---------------------------------------------------------------------------------------------------------
--!!! BEFORE YOU RUN THIS SCRIPT !!!
--Create a new schema, name it 'lotus', and then set it to default.

--SECTION 1: TABLE CREATION

--The guest table will hold the records of whomever booked the room and provided credit card information.
CREATE TABLE guest (
  --g_id is the guest id.
    g_id serial primary key,
  --f_name is the paying guest's first name.
    f_name text not null,
  --l_name is the paying guest's last name.
    l_name text not null,
  --cc_num is the paying guests credit card number.
    cc_num text not null
);

--The room table holds all the rooms in the hotel and the information about them. 
CREATE TABLE room (
  --r_id is room_id as well as the physical room number. 
    r_id serial primary key,
  --status can be remembered by R.O.O.M. --> Ressetting, Open, Occupied, Maintenance. 
    status text not null,
  --bed_num is bed number and will always be 1 or 2.
    bed_num int not null,
  --bed_size will always be 'single' or 'double'.
    bed_size text not null,
  --lux_lev is luxury level and will always be 'standard' or 'luxury'.
    lux_lev text not null,
  --cpn is cost per night.
    cpn money not null
);

--The stay table will hold the information for one booking of a single room.
--If the same party book multiple rooms they will be recorded as multiple stays.
--ch_o_time and ch_o_date are not constrained so that extending stays is easier.
CREATE TABLE stay (
  --s_id is stay id
	s_id serial primary key,
  --ch_i_time is check-in-time.
    ch_i_time time not null,
  --ch_i_date is check-in-date.
    ch_i_date date not null,
  --ch_o_time is check-out-time.
    ch_o_time time,
  --ch_o_date is check-out-date.
    ch_o_date date,
  --g_id from guest (foreign key).
    g_id int references guest (g_id),
  --r_id from room (foreign key).
    r_id int references room (r_id),
  --bill is the total amount that the stay cost at checkout.
    bill money not null
);
--Standard ch_o_time is 10:00 AM. This can be changed.

--The online_user table will hold the information about online users making reservations.
CREATE TABLE online_user (
  --u_id is user id.
	u_id serial primary key,
	user_name text not null,
	pass_word text not null,
	email text not null
);

--The reservation table will hold the information for one booking of a single room.
--At the time of check-in the reservation's information will be transferred to a stay.
--At that time, the user's information will be transferred to a guest.
--When the transfer happens, business logic will determine the stay's bill.
--This structure is used to make reservations easier online.
--ch_o_time and ch_o_date are not constrained so that extending stays is easier.
CREATE TABLE reservation (
  --res_id is reservation id.
    res_id serial primary key,
  --ch_i_time is check-in-time.
    ch_i_time time not null,
  --ch_i_date is check-in-date.
    ch_i_date date not null,
  --ch_o_time is check-out-time.
    ch_o_time time,
  --ch_o_date is check-out-date.
    ch_o_date date,
  --r_id from room (foreign key).
    r_id int references room (r_id),
  --u_id from online_user (foreign key).
    u_id int references online_user (u_id),
  --status will be 'upcoming', 'completed', or 'canceled'.
    status text not null
);
--Standard ch_o_time is 10:00 AM. This can be changed.

--The rs_order table will hold a single room service order.
CREATE TABLE rs_order (
    order_id serial primary key,
  --r_id from room (foreign key).
    r_id int references room (r_id),
  --order_tot is order total, which can be added to a stay's bill.
    order_tot money not null
);

--The serv_item table will hold the items available for order as room service.
CREATE TABLE serv_item (
    item_id serial primary key,
    item_name text not null,
    price money not null
);

--The serv_row table will hold the rows of a single room service order.
CREATE TABLE serv_row (
    row_id serial primary key,
  --item_id from serv_items (foreign key).
    item_id int references serv_item(item_id),
 --order_id from rs_order (foreign key).
   order_id int references rs_order(order_id)
);

--SECTION 2: Table population

--Populate the serv_item table
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

--Populate the room table
--12 standard single rooms. Sleeps 1 person in 1 single bed
--1
INSERT INTO room (status, bed_num, bed_size, lux_lev, cpn)
VALUES ('open', 1, 'single', 'standard', 100.00);
--2
INSERT INTO room (status, bed_num, bed_size, lux_lev, cpn)
VALUES ('open', 1, 'single', 'standard', 100.00);
--3
INSERT INTO room (status, bed_num, bed_size, lux_lev, cpn)
VALUES ('open', 1, 'single', 'standard', 100.00);
--4
INSERT INTO room (status, bed_num, bed_size, lux_lev, cpn)
VALUES ('open', 1, 'single', 'standard', 100.00);
--5
INSERT INTO room (status, bed_num, bed_size, lux_lev, cpn)
VALUES ('open', 1, 'single', 'standard', 100.00);
--6
INSERT INTO room (status, bed_num, bed_size, lux_lev, cpn)
VALUES ('open', 1, 'single', 'standard', 100.00);
--7
INSERT INTO room (status, bed_num, bed_size, lux_lev, cpn)
VALUES ('open', 1, 'single', 'standard', 100.00);
--8
INSERT INTO room (status, bed_num, bed_size, lux_lev, cpn)
VALUES ('open', 1, 'single', 'standard', 100.00);
--9
INSERT INTO room (status, bed_num, bed_size, lux_lev, cpn)
VALUES ('open', 1, 'single', 'standard', 100.00);
--10
INSERT INTO room (status, bed_num, bed_size, lux_lev, cpn)
VALUES ('open', 1, 'single', 'standard', 100.00);
--11
INSERT INTO room (status, bed_num, bed_size, lux_lev, cpn)
VALUES ('open', 1, 'single', 'standard', 100.00);
--12
INSERT INTO room (status, bed_num, bed_size, lux_lev, cpn)
VALUES ('open', 1, 'single', 'standard', 100.00);
-- Then 4 of the same but luxury
--1
INSERT INTO room (status, bed_num, bed_size, lux_lev, cpn)
VALUES ('open', 1, 'single', 'luxury', 400.00);
--2
INSERT INTO room (status, bed_num, bed_size, lux_lev, cpn)
VALUES ('open', 1, 'single', 'luxury', 400.00);
--3
INSERT INTO room (status, bed_num, bed_size, lux_lev, cpn)
VALUES ('open', 1, 'single', 'luxury', 400.00);
--4
INSERT INTO room (status, bed_num, bed_size, lux_lev, cpn)
VALUES ('open', 1, 'single', 'luxury', 400.00);
--12 regular double rooms. Sleeps 2 people in 2 single person beds.
--1
INSERT INTO room (status, bed_num, bed_size, lux_lev, cpn)
VALUES ('open', 2, 'single', 'standard', 200.00);
--2
INSERT INTO room (status, bed_num, bed_size, lux_lev, cpn)
VALUES ('open', 2, 'single', 'standard', 200.00);
--3
INSERT INTO room (status, bed_num, bed_size, lux_lev, cpn)
VALUES ('open', 2, 'single', 'standard', 200.00);
--4
INSERT INTO room (status, bed_num, bed_size, lux_lev, cpn)
VALUES ('open', 2, 'single', 'standard', 200.00);
--5
INSERT INTO room (status, bed_num, bed_size, lux_lev, cpn)
VALUES ('open', 2, 'single', 'standard', 200.00);
--6
INSERT INTO room (status, bed_num, bed_size, lux_lev, cpn)
VALUES ('open', 2, 'single', 'standard', 200.00);
--7
INSERT INTO room (status, bed_num, bed_size, lux_lev, cpn)
VALUES ('open', 2, 'single', 'standard', 200.00);
--8
INSERT INTO room (status, bed_num, bed_size, lux_lev, cpn)
VALUES ('open', 2, 'single', 'standard', 200.00);
--9
INSERT INTO room (status, bed_num, bed_size, lux_lev, cpn)
VALUES ('open', 2, 'single', 'standard', 200.00);
--10
INSERT INTO room (status, bed_num, bed_size, lux_lev, cpn)
VALUES ('open', 2, 'single', 'standard', 200.00);
--11
INSERT INTO room (status, bed_num, bed_size, lux_lev, cpn)
VALUES ('open', 2, 'single', 'standard', 200.00);
--12
INSERT INTO room (status, bed_num, bed_size, lux_lev, cpn)
VALUES ('open', 2, 'single', 'standard', 200.00);
--4 more of the same but luxury
--1
INSERT INTO room (status, bed_num, bed_size, lux_lev, cpn)
VALUES ('open', 2, 'single', 'luxury', 600.00);
--2
INSERT INTO room (status, bed_num, bed_size, lux_lev, cpn)
VALUES ('open', 2, 'single', 'luxury', 600.00);
--3
INSERT INTO room (status, bed_num, bed_size, lux_lev, cpn)
VALUES ('open', 2, 'single', 'luxury', 600.00);
--4
INSERT INTO room (status, bed_num, bed_size, lux_lev, cpn)
VALUES ('open', 2, 'single', 'luxury', 600.00);
--12 regular couple rooms. Sleeps 2 people in 1 double person beds.
--1
INSERT INTO room (status, bed_num, bed_size, lux_lev, cpn)
VALUES ('open', 1, 'double', 'standard', 150.00);
--2
INSERT INTO room (status, bed_num, bed_size, lux_lev, cpn)
VALUES ('open', 1, 'double', 'standard', 150.00);
--3
INSERT INTO room (status, bed_num, bed_size, lux_lev, cpn)
VALUES ('open', 1, 'double', 'standard', 150.00);
--4
INSERT INTO room (status, bed_num, bed_size, lux_lev, cpn)
VALUES ('open', 1, 'double', 'standard', 150.00);
--5
INSERT INTO room (status, bed_num, bed_size, lux_lev, cpn)
VALUES ('open', 1, 'double', 'standard', 150.00);
--6
INSERT INTO room (status, bed_num, bed_size, lux_lev, cpn)
VALUES ('open', 1, 'double', 'standard', 150.00);
--7
INSERT INTO room (status, bed_num, bed_size, lux_lev, cpn)
VALUES ('open', 1, 'double', 'standard', 150.00);
--8
INSERT INTO room (status, bed_num, bed_size, lux_lev, cpn)
VALUES ('open', 1, 'double', 'standard', 150.00);
--9
INSERT INTO room (status, bed_num, bed_size, lux_lev, cpn)
VALUES ('open', 1, 'double', 'standard', 150.00);
--10
INSERT INTO room (status, bed_num, bed_size, lux_lev, cpn)
VALUES ('open', 1, 'double', 'standard', 150.00);
--11
INSERT INTO room (status, bed_num, bed_size, lux_lev, cpn)
VALUES ('open', 1, 'double', 'standard', 150.00);
--12
INSERT INTO room (status, bed_num, bed_size, lux_lev, cpn)
VALUES ('open', 1, 'double', 'standard', 150.00);
--6 more of the same but luxury
--1
INSERT INTO room (status, bed_num, bed_size, lux_lev, cpn)
VALUES ('open', 1, 'double', 'luxury', 550.00);
--2
INSERT INTO room (status, bed_num, bed_size, lux_lev, cpn)
VALUES ('open', 1, 'double', 'luxury', 550.00);
--3
INSERT INTO room (status, bed_num, bed_size, lux_lev, cpn)
VALUES ('open', 1, 'double', 'luxury', 550.00);
--4
INSERT INTO room (status, bed_num, bed_size, lux_lev, cpn)
VALUES ('open', 1, 'double', 'luxury', 550.00);
--5
INSERT INTO room (status, bed_num, bed_size, lux_lev, cpn)
VALUES ('open', 1, 'double', 'luxury', 550.00);
--6
INSERT INTO room (status, bed_num, bed_size, lux_lev, cpn)
VALUES ('open', 1, 'double', 'luxury', 550.00);
--4 family rooms. Sleeps 4 people in 2 double beds.
--1
INSERT INTO room (status, bed_num, bed_size, lux_lev, cpn)
VALUES ('open', 2, 'double', 'standard', 400.00);
--2
INSERT INTO room (status, bed_num, bed_size, lux_lev, cpn)
VALUES ('open', 2, 'double', 'standard', 400.00);
--3
INSERT INTO room (status, bed_num, bed_size, lux_lev, cpn)
VALUES ('open', 2, 'double', 'standard', 400.00);
--4
INSERT INTO room (status, bed_num, bed_size, lux_lev, cpn)
VALUES ('open', 2, 'double', 'standard', 400.00);
--2 more of the same but luxury
--1
INSERT INTO room (status, bed_num, bed_size, lux_lev, cpn)
VALUES ('open', 2, 'double', 'luxury', 700.00);
--2
INSERT INTO room (status, bed_num, bed_size, lux_lev, cpn)
VALUES ('open', 2, 'double', 'luxury', 700.00);

--Populate the online_user table
INSERT INTO online_user (user_name, pass_word, email)
VALUES ('kitkat123', 'paswood', 'kit_kat@yahoo.com');
INSERT INTO online_user (user_name, pass_word, email)
VALUES ('leondrake', '3434dw', 'lanesmith@gmail.com');
INSERT INTO online_user (user_name, pass_word, email)
VALUES ('B0B', 'bobob', 'bobbob@bob.bob');
INSERT INTO online_user (user_name, pass_word, email)
VALUES ('Jsonandre', 'lastofus', 'gamer45@aol.com');
INSERT INTO online_user (user_name, pass_word, email)
VALUES ('EmmaSmith57', 'likefire38', 'book_wurm@yahoo.com');

--Populate the reservation table
INSERT INTO reservation (ch_i_time, ch_i_date, ch_o_time, ch_o_date, r_id, u_id, status)
                VALUES ('5:30', '2/24/12', '10:00', '2/26/12', 1, 1, 'completed');
INSERT INTO reservation (ch_i_time, ch_i_date, ch_o_time, ch_o_date, r_id, u_id, status)
                VALUES ('4:34', '1/1/22', '10:00', '2/2/22', 3, 2, 'canceled');
INSERT INTO reservation (ch_i_time, ch_i_date, ch_o_time, ch_o_date, r_id, u_id, status)
                VALUES ('12:00', '3/20/22', '10:00', '3/21/22', 3, 3, 'upcoming');
INSERT INTO reservation (ch_i_time, ch_i_date, ch_o_time, ch_o_date, r_id, u_id, status)
                VALUES ('11:00', '4/20/22', '10:00', '4/21/22', 3, 4, 'upcoming');
INSERT INTO reservation (ch_i_time, ch_i_date, ch_o_time, ch_o_date, r_id, u_id, status)
                VALUES ('12:00', '5/20/22', '10:00', '5/21/22', 4, 5, 'upcoming');
               
--Populate the guest table           
INSERT INTO guest (f_name, l_name, cc_num)
VALUES ('Bob', 'Reynolds', '1234-8765-0987-4321');
INSERT INTO guest (f_name, l_name, cc_num)
VALUES ('Darren', 'Jay', '1264-8765-0987-4321');
INSERT INTO guest (f_name, l_name, cc_num)
VALUES ('Stacy', 'Reynolds', '7634-8765-0987-4321');
INSERT INTO guest (f_name, l_name, cc_num)
VALUES ('Sam', 'Smith', '1234-8765-0087-4321');
INSERT INTO guest (f_name, l_name, cc_num)
VALUES ('Tasha', 'Keana', '1234-8765-0000-4321');
INSERT INTO guest (f_name, l_name, cc_num)
VALUES ('Stray', 'Cat', '1234-8765-2365-4321');

--Populate the stay table           
INSERT INTO stay (ch_i_time, ch_i_date, ch_o_time, ch_o_date, g_id, r_id, bill)
          VALUES ('5:30', '3/23/21', '10:00', '3/24/21', 1, 1, (select cpn from room where r_id = 1));
INSERT INTO stay (ch_i_time, ch_i_date, ch_o_time, ch_o_date, g_id, r_id, bill)
          VALUES ('7:30', '3/23/21', '10:00', '3/26/21', 2, 2, (3*(select cpn from room where r_id = 2)));        
INSERT INTO stay (ch_i_time, ch_i_date, ch_o_time, ch_o_date, g_id, r_id, bill)
          VALUES ('7:30', '3/23/20', '10:00', '3/26/20', 2, 2, (3*(select cpn from room where r_id = 2)));
INSERT INTO stay (ch_i_time, ch_i_date, ch_o_time, ch_o_date, g_id, r_id, bill)
          VALUES ('7:30', '3/23/19', '10:00', '3/26/19', 2, 2, (3*(select cpn from room where r_id = 2)));
INSERT INTO stay (ch_i_time, ch_i_date, ch_o_time, ch_o_date, g_id, r_id, bill)
          VALUES ('7:30', '3/27/21', '10:00', '3/30/21', 3, 3, (3*(select cpn from room where r_id = 3)));
         --Imagine this last record is current. THe room is changed to occupied to reflect that. 
         update room set status  = 'occupied' where r_id = 3;

--Set a few rooms to different status just for variety
update room set status  = 'resetting' where r_id = 5;
update room set status  = 'resetting' where r_id = 10;
update room set status  = 'resetting' where r_id = 15;
update room set status  = 'resetting' where r_id = 21;
update room set status  = 'maintenance' where r_id = 30;
update room set status  = 'maintenance' where r_id = 31;