package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
		
		List<Hotel> hotels1= this.iHotelService.buscarInnerJoin();
		hotels1.forEach(h ->{
			System.out.println("#HOTEL#");
			System.out.println(h);
			System.out.println("Habitaciones");
			System.out.println(h.getHabitaciones());
		});
		
	}

	
}
