package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.banco.repo.ITransferenciaRepo;
import com.example.demo.banco.repo.modelo.CuentaBancaria;
import com.example.demo.banco.repo.modelo.Habitacion;
import com.example.demo.banco.repo.modelo.Hotel;
import com.example.demo.banco.repo.modelo.Propietario;
import com.example.demo.banco.service.ICuentaBancariaService;
import com.example.demo.banco.service.IHabitacionService;
import com.example.demo.banco.service.IHotelService;
import com.example.demo.banco.service.ITransferenciaService;

@SpringBootApplication
public class Pa2U3P4DllYfApplication implements CommandLineRunner {

	@Autowired
	private IHotelService iHotelService;

	@Autowired
	private IHabitacionService iHabitacionService;
	
	
	@Autowired
	private ICuentaBancariaService iCuentaBancariaService;
	
	@Autowired
	private ITransferenciaService iTransferenciaService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4DllYfApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("UNIDAD 3");
		
		Propietario propietario1=new Propietario();
		propietario1.setApellido("Molina");
		propietario1.setCedula("1712341234");
		propietario1.setCuentasBancarias(null);
		propietario1.setNombre("Daniel");
		
		CuentaBancaria cuentaBancaria1=new CuentaBancaria();
		cuentaBancaria1.setNumero("1234");
		cuentaBancaria1.setPropietario(propietario1);
		cuentaBancaria1.setSaldo(new BigDecimal(10000));
		cuentaBancaria1.setTipo("A");
		List<CuentaBancaria> cuentasBancarias1= new ArrayList<>();
		cuentasBancarias1.add(cuentaBancaria1);
		
		propietario1.setCuentasBancarias(cuentasBancarias1);
		
		this.iCuentaBancariaService.agregar(cuentaBancaria1);

		this.iTransferenciaService.transferir(cuentaBancaria1.getId(), 2, new BigDecimal(100));
		
		this.iTransferenciaService.reporte().forEach(System.out::println);
		
	}

}
