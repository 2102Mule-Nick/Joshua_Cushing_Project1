package com.lotus.staykeep.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lotus.staykeep.config.AppConfig;

public class StaykeepTestCentral {
			//This is what I was missing. Thanks Iyad. 
			ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
			
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
