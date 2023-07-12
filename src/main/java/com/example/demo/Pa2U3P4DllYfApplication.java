package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.banco.repo.modelo.Habitacion;
import com.example.demo.banco.repo.modelo.Hotel;
import com.example.demo.banco.service.IHabitacionService;
import com.example.demo.banco.service.IHotelService;

@SpringBootApplication
public class Pa2U3P4DllYfApplication implements CommandLineRunner{

	@Autowired
	private IHotelService iHotelService;
	
	@Autowired
	private IHabitacionService iHabitacionService;

	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4DllYfApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("UNIDAD 3");
		/*System.out.println("INNER JOIN");
		List<Hotel> hotels1= this.iHotelService.buscarInnerJoin();
		hotels1.forEach(h ->{
			System.out.println("#HOTEL#");
			System.out.println(h);
			System.out.println("Habitaciones:");
			System.out.println(h.getHabitaciones());
		});
		*/
		System.out.println("********OUTER RIGHT JOIN********");
		List<Hotel> hotels2= this.iHotelService.buscarOuterRightJoin();
		hotels2.forEach(h ->{
			System.out.println("#HOTEL#");
			System.out.println(h);
			if(h!=null) {
				System.out.println("Habitaciones:");
				System.out.println(h.getHabitaciones());
			}else {
				System.out.println("No existe aun hotel");
			}
			
		});
		
		System.out.println("********OUTER LEFT JOIN********");
		List<Hotel> hotels3= this.iHotelService.buscarOuterLeftJoin();
		hotels3.forEach(h ->{
			System.out.println("#HOTEL#");
			System.out.println(h);
			if(h!=null) {
				System.out.println("Habitaciones:");
				System.out.println(h.getHabitaciones());
			}else {
				System.out.println("No existe aun hotel");
			}
			
		});
		
		System.out.println("********OUTER LEFT JOIN HABITACION********");
		List<Habitacion> habitaciones1= this.iHotelService.buscarHabitacionOuterLeftJoin();
		habitaciones1.forEach(ha ->{
			System.out.println("#Habitaciones#");
			System.out.println(ha);
			if(ha!=null) {
				System.out.println("Hotel:");
				System.out.println(ha.getHotel());
			}else {
				System.out.println("No existe aun habitacion");
			}
			
			
		});
		
		
		System.out.println("********OUTER FULL JOIN********");
		List<Hotel> hotels4= this.iHotelService.buscarOuterFullJoin();
		hotels4.forEach(h ->{
			System.out.println("#HOTEL#");
			System.out.println(h);
			if(h!=null) {
				System.out.println("Habitaciones:");
				System.out.println(h.getHabitaciones());
			}else {
				System.out.println("No existe aun hotel");
			}
			
		});
		
		System.out.println("********WHERE JOIN********");
		List<Hotel> hotels5= this.iHotelService.buscarWhereJoin();
		hotels5.forEach(h ->{
			System.out.println("#HOTEL#");
			System.out.println(h);
			if(h!=null) {
				System.out.println("Habitaciones:");
				System.out.println(h.getHabitaciones());
			}else {
				System.out.println("No existe aun hotel");
			}
			
		});
		
		
	}
	
	

	
}
