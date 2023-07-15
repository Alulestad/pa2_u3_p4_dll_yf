package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
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
public class Pa2U3P4DllYfApplication implements CommandLineRunner {

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
		/*
		
		hotels1.forEach(h -> {

			System.out.println("Hotel: " + h.getNombre());
			System.out.println("Tiene las siguientes habitaciones: ");
			List<Habitacion> habitaciones = h.getHabitaciones();
			habitaciones.forEach(ha -> {
				System.out.println(ha.getNumero());
			});

		});
		*/
		// 2da ver:
		System.out.println("########## Inner Join (LAZY) ##########");
		List<Hotel> hotels1 = this.iHotelService.buscarInnerJoin();
		for (Hotel h : hotels1) {
			System.out.println(h.getNombre());
			System.out.println("Tiene las siguientes habitaciones: ");

			for (Habitacion ha : h.getHabitaciones()) {
				System.out.println(ha.getNumero());
			}
		}
		
		System.out.println("########## SQL Join Fetch ##########");
		List<Hotel> hotels1F = this.iHotelService.buscarFetchJoin();
		for (Hotel h : hotels1F) {
			System.out.println(h.getNombre());
			System.out.println("Tiene las siguientes habitaciones: ");

			for (Habitacion ha : h.getHabitaciones()) {
				System.out.println(ha.getNumero());
			}
		}
		
		//
		
		
		Hotel hotel1=new Hotel();
		
		hotel1.setDireccion("Yaniry's House");
		hotel1.setNombre("Bonito");
		
		Habitacion habi1=new Habitacion();
		habi1.setNumero("N8");
		habi1.setValor(new BigDecimal(20));
		
		Habitacion habi2=new Habitacion();
		habi2.setNumero("N9");
		habi2.setValor(new BigDecimal(25));
		
		Habitacion habi3=new Habitacion();
		habi3.setNumero("N10");
		habi3.setValor(new BigDecimal(30));
		
		
		habi1.setHotel(hotel1);
		habi2.setHotel(hotel1);
		habi3.setHotel(hotel1);
		
		List<Habitacion> habitaciones1= new ArrayList<>();
		habitaciones1.add(habi1);
		habitaciones1.add(habi2);
		habitaciones1.add(habi3);
		
		hotel1.setHabitaciones(habitaciones1);

		this.iHotelService.guardar(hotel1);
		
		habitaciones1.forEach(ha->{
			System.out.println("Numero: "+ha.getNumero());
			System.out.println("Valor con iva: "+ha.getValorIncluidoIva());
		});

	}

}
