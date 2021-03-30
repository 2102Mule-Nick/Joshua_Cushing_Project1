--Functions. Run these one at a time. They will make an error otherwise.
--Make certain that the setup script has been run first.
--(#variable_conflict use_column) is necessary for specifying that some variables are column names.


--USED BY ROOMDAO----------------------------------------------------------------

--FUNCTION 1: Gets all information for a certain room by inputting r_id.
create or replace function get_room_info_by_id(id int)
   returns table(
   		r_id int,
   		status text,
   		bed_num int,
   		bed_size text,
   		lux_lev text,
   		cpn money
   )
   language plpgsql
  as
$$
#variable_conflict use_column
begin
	return query	
	select
		r.r_id,
		r.status,
   		r.bed_num,
   		r.bed_size,
   		r.lux_lev,
   		r.cpn
	from 
		room r
	where
		r_id = id;
end;
$$
	--Test the function. 
	--Test 1: Should return: a real result set. 
		--select * from get_room_info_by_id(5);
	--Test 2: Should return: empty results.
	--There are only 56 rooms.
		--select * from get_room_info_by_id(100);
	
--FUNCTION 2: Change room status when a status and id are entered.
create or replace function change_room_status( stat text, id int)
   returns void
   language plpgsql
  as
$$
#variable_conflict use_column
begin
	update room
	set status = stat
	where r_id = id;
end;
$$



	--Test the function. 
	--Test 1: Should return: an empty result set. Check table to see results.
    select change_room_status('teststatus', 7);
	--THEN
	select change_room_status('open', 7);




































































































------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------







-----UNUSED-----------------------------------------------------------------------------------





--FUNCTION 2: Gets all the stays attributed with a certain room.
create or replace function get_stays_by_room(id int)
   returns table(
   		s_id int,
   		ch_i_time time,
   		ch_i_date date,
   		ch_o_time time,
   		ch_o_date date,
   		g_id int,
   		r_id int,
   		bill money
   )
   language plpgsql
  as
$$
#variable_conflict use_column
declare 
	r_id_holder int = id;
begin
	return query	
	select 
		s_id,
   		ch_i_time,
   		ch_i_date,
   		ch_o_time,
   		ch_o_date,
   		g_id,
   		r_id,
   		bill
	from 
		stay 
	where r_id = r_id_holder;
end;
$$
	--Test the function. 
	--Test 1: Should return: a real result set.
		select * from  get_stays_by_room(2);
	--Test 2: Should return: empty results.
		--select * from  get_stays_by_room(100);


--FUNCTION 3: Gets all resrvations attributed with a certain room.
create or replace function get_reservations_by_room(id int)
   returns table(
   		res_id int,
   		ch_i_time time,
   		ch_i_date date,
   		ch_o_time time,
   		ch_o_date date,
   		u_id int,
   		r_id int,
   		status text,
   		user_name text
   )
   language plpgsql
  as
$$
#variable_conflict use_column
begin
	return query	
	select 
		r.res_id,
   		r.ch_i_time,
   		r.ch_i_date,
   		r.ch_o_time,
   		r.ch_o_date,
   		r.u_id,
   		r.r_id,
   		r.status,
   		o.user_name
	from 
		reservation r  
	inner join 
		online_user o
	on 
	    r.u_id = o.u_id 
	where r.r_id = id;
end;
$$
	--Test the function. 
	--Test 1: Should return: a real result set.
		--select * from  get_reservations_by_room(3);
	--Test 2: Should return: empty results.
		--select * from  get_reservations_by_room(100);

--Function 4: Change room status when a status and id are entered.
create or replace function change_room_status(id int, stat text)
   returns void
   language plpgsql
  as
$$
#variable_conflict use_column
begin
	update room
	set status = stat
	where r_id = id;
end;
$$
	--Test the function. 
	--Test 1: Should return: an empty result set. Check table to see results.
    	--select change_room_status(7, 'teststatus');
	--THEN
		--select change_room_status(7, 'open');



--USED BY GUESTDAO----------------------------------------------------------------

--FUNCTION 1: Gets all information for a certain guest by inputting g_id.
create or replace function get_guest_info_by_id(id int)
   returns table(
   		g_id int,
   		f_name text,
   		l_name text,
   		cc_num text
   )
   language plpgsql
  as
$$
#variable_conflict use_column
begin
	return query	
	select
		g_id,
		f_name,
   		l_name,
   		cc_num
	from 
		guest
	where
		g_id = id;
end;
$$
	--Test the function. 
	--Test 1: Should return: a real result set. 
		--select * from get_guest_info_by_id(1);
	--Test 2: Should return: empty results.
	--There are only 56 rooms.
		--select * from get_guest_info_by_id(100);


--USED BY RESERVATIONDAO----------------------------------------------------------------
	
--FUNCTION 1: Gets all upcoming reservations.
create or replace function get_all_res_status(stat text)
returns table(
   		res_id int,
   		ch_i_time time,
   		ch_i_date date,
   		ch_o_time time,
   		ch_o_date date,
   		r_id int,
   		u_id int,
   		status text
   )
   language plpgsql
  as
$$
#variable_conflict use_column
begin
	return query	
	select *
	from 
		reservation
	where status = stat;
end;
$$
	--Test the function. 
	--Test 1: Should return: a real result set
	--select * from  get_all_res_status('upcoming');

--FUNCTION 2: change reservation ch_i_time.
create or replace function change_res_in_time(id int, nu_time time)
returns void
   language plpgsql
  as
$$
#variable_conflict use_column
begin	
	update reservation 
	set ch_i_time = nu_time
	where res_id = id;
end;
$$
	--Test the function. 
	--Test 1: Should return: a real result set
	select * from  change_res_in_time(3, '11:00');

--FUNCTION 3: change reservation ch_i_date.
create or replace function change_res_in_date(id int, nu_date date)
returns void
   language plpgsql
  as
$$
#variable_conflict use_column
begin	
	update reservation 
	set ch_i_date = nu_date
	where res_id = id;
end;
$$
	--Test the function. 
	--Test 1: Should return: a real result set
	--select * from  change_res_in_date(3, '03/21/21');

--FUNCTION 4: change reservation ch_o_time.
create or replace function change_res_out_time(id int, nu_time time)
returns void
   language plpgsql
  as
$$
#variable_conflict use_column
begin	
	update reservation 
	set ch_o_time = nu_time
	where res_id = id;
end;
$$
	--Test the function. 
	--Test 1: Should return: a real result set
	--select * from  change_res_out_time(3, '11:00');

--FUNCTION 5: change reservation ch_o_date.
create or replace function change_res_out_date(id int, nu_date date)
returns void
   language plpgsql
  as
$$
#variable_conflict use_column
begin	
	update reservation 
	set ch_o_date = nu_date
	where res_id = id;
end;
$$
	--Test the function. 
	--Test 1: Should return: a real result set
	--select * from  change_res_out_date(3, '03/21/21');

--FUNCTION 6: change reservation status.
create or replace function change_res_status(id int, stat text)
   returns void
   language plpgsql
  as
$$
#variable_conflict use_column
begin
	update reservation 
	set status = stat
	where res_id = id;
end;
$$
	--Test the function. 
	--Test 1: Should return: a real result set
	--select * from change_res_status(5, 'upcoming');








--Function 1: Gets a u_id from online_user by inputting name and password.
create or replace function get_u_id_by_cred(user_name_input text, pass_word_input text)
   returns int 
   language plpgsql
  as
$$
declare 
	u_id_exists int;
begin
	select u_id 
	into u_id_exists
	from online_user
	where user_name = user_name_input 
	and pass_word  = pass_word_input;

	return u_id_exists;
end;
$$
	--Test the function. 
	--Test 1: Should return 1
	--select get_u_id_by_cred('kitkat123', 'paswood');

	--Test 2: Should return NULL
	--select get_u_id_by_cred('fakeusername', 'notrealpassword');



--Function 3: Gets all reservations for a certain room.
create or replace function get_all_res_by_room(id int)
   returns table(
   		res_id int,
   		ch_i_time time,
   		ch_i_date date,
   		ch_o_time time,
   		ch_o_date date,
   		r_id int,
   		u_id int,
   		status text
   )
   language plpgsql
  as
$$
#variable_conflict use_column
begin
	return query	
	select *
	from 
		reservation
	where r_id = id;
end;
$$
	--Test the function. 
	--Test 1: Should return: a real result set
	--select * from get_all_res_by_room(3);

	--Test 2: Should return: empty result set.
	--There are only 56 rooms.
	--select * from get_all_res_by_room(100);













--Function 5: Gets all completed reservations.
create or replace function get_all_completed_res()
   returns table(
   		res_id int,
   		ch_i_time time,
   		ch_i_date date,
   		ch_o_time time,
   		ch_o_date date,
   		r_id int,
   		u_id int,
   		status text
   )
   language plpgsql
  as
$$
#variable_conflict use_column
begin
	return query	
	select *
	from 
		reservation
	where status = 'completed';
end;
$$
	--Test the function. 
	--Test 1: Should return: a real result set
	--select * from  get_all_completed_res();

--Function 6: Gets all canceled reservations.
create or replace function get_all_canceled_res()
   returns table(
   		res_id int,
   		ch_i_time time,
   		ch_i_date date,
   		ch_o_time time,
   		ch_o_date date,
   		r_id int,
   		u_id int,
   		status text
   )
   language plpgsql
  as
$$
#variable_conflict use_column
begin
	return query	
	select *
	from 
		reservation
	where status = 'canceled';
end;
$$
	--Test the function. 
	--Test 1: Should return: a real result set
	--select * from  get_all_canceled_res();

--Function 7: Gets all available rooms.
create or replace function get_all_open_rooms()
   returns table(
   		r_id int,
   		status text,
   		bed_num int,
   		bed_size text,
   		lux_lev text,
   		cpn money
   )
   language plpgsql
  as
$$
#variable_conflict use_column
begin
	return query	
	select *
	from 
		room
	where status = 'open';
end;
$$
	--Test the function. 
	--Test 1: Should return: a real result set
	--select * from get_all_open_rooms();

--Function 8: Gets all occupied rooms.
create or replace function get_all_occupied_rooms()
   returns table(
   		r_id int,
   		status text,
   		bed_num int,
   		bed_size text,
   		lux_lev text,
   		cpn money
   )
   language plpgsql
  as
$$
#variable_conflict use_column
begin
	return query	
	select *
	from 
		room
	where status = 'occupied';
end;
$$
	--Test the function. 
	--Test 1: Should return: a real result set
	--select * from get_all_occupied_rooms();

--Function 9: Gets all ressetting rooms.
create or replace function get_all_resetting_rooms()
   returns table(
   		r_id int,
   		status text,
   		bed_num int,
   		bed_size text,
   		lux_lev text,
   		cpn money
   )
   language plpgsql
  as
$$
#variable_conflict use_column
begin
	return query	
	select *
	from 
		room
	where status = 'resetting';
end;
$$
	--Test the function. 
	--Test 1: Should return: a real result set
	--select * from get_all_resetting_rooms();

--Function 10: Gets all maintenance rooms.
create or replace function get_all_maintenance_rooms()
   returns table(
   		r_id int,
   		status text,
   		bed_num int,
   		bed_size text,
   		lux_lev text,
   		cpn money
   )
   language plpgsql
  as
$$
#variable_conflict use_column
begin
	return query	
	select *
	from 
		room
	where status = 'maintenance';
end;
$$
	--Test the function. 
	--Test 1: Should return: a real result set
	--select * from get_all_maintenance_rooms();
	
 












