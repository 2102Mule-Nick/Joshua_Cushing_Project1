package com.lotus.staykeep;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.lotus.staykeep.config.AppConfig;
import com.lotus.staykeep.daoimpl.RoomDaoImpl;
import com.lotus.staykeep.pojo.Reservation;
import com.lotus.staykeep.pojo.Room;
import com.lotus.staykeep.pojo.Stay;


//THIS IS A TEST DRIVER
public class Driver {
	
	public static void main(String[] args) {
		//This is what I was missing. Thanks Iyad. 
		//ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		//ROOM DAO IMPL TESTS
		//RoomDaoImpl roomDaoImpl = appContext.getBean("roomDaoImpl", RoomDaoImpl.class);
		
		//TEST 1: passed
		//Room room = roomDaoImpl.getRoomInfoById(5);
		//System.out.println(room);
		
		//TEST 2: passed
		//roomDaoImpl.setRoomStatus("open", 5);
		
		//TEST 3: passed
		//List<Stay> stayList = roomDaoImpl.getStaysByRoom(2);
		//System.out.println(stayList);
		
		//TEST 4: passed
		//List<Reservation> reservationList = roomDaoImpl.getReservationsByRoom(3);
		//System.out.println(reservationList);
	}
}























		//TEST 2 DOES NOT WORK. HATES MY STORED FUNCTION FOR SOME REASON
		//List<Stay> stayList = roomDaoImpl.getStaysByRoom(2);
		//System.out.println(stayList);
		
		//TEST 3 DOES NOT WORK. HATES MY STORED FUNCTION FOR SOME REASON
		//List<Reservation> resList  =  roomDaoImpl.getReservationsByRoom(3);
		//System.out.println(resList);
		
		//TEST 3 DOES NOT WORK. HATES MY STORED FUNCTION FOR SOME REASON
		//roomDaoImpl.changeRoomStatus((Integer) 42, (String)"Occupied");