package com.lotus.staykeep;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.lotus.staykeep.config.AppConfig;
import com.lotus.staykeep.dao.RoomDao;
import com.lotus.staykeep.daoimpl.RoomDaoImpl;
import com.lotus.staykeep.pojo.Room;

//THIS IS A TEST DRIVER
public class Driver {
	
	public static void main(String[] args) {
		//This is what I was missing. Thanks Iyad. 
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		RoomDao roomDaoImpl = appContext.getBean("roomDaoImpl", RoomDaoImpl.class);
		
		// TEST 1 WORKS
		//Room room  =  roomDaoImpl.getRoomInfoById(3);
		//System.out.println(room);
		
		//TEST 2
		roomDaoImpl.changeRoomStatus("occupied", 6);

		
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