package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.demo.banco.repo.ITransferenciaRepo;
import com.example.demo.banco.repo.modelo.CuentaBancaria;
import com.example.demo.banco.repo.modelo.Estudiante;
import com.example.demo.banco.repo.modelo.Habitacion;
import com.example.demo.banco.repo.modelo.Hotel;
import com.example.demo.banco.repo.modelo.Materia;
import com.example.demo.banco.repo.modelo.Propietario;
import com.example.demo.banco.repo.modelo.Provincia;
import com.example.demo.banco.repo.modelo.Semestre;
import com.example.demo.banco.service.ICuentaBancariaService;
import com.example.demo.banco.service.IEstudianteService;
import com.example.demo.banco.service.IHabitacionService;
import com.example.demo.banco.service.IHotelService;
import com.example.demo.banco.service.IMateriaService;
import com.example.demo.banco.service.IMatriculaService;
import com.example.demo.banco.service.IPropietarioService;
import com.example.demo.banco.service.ITransferenciaService;

import jakarta.transaction.Transactional;

@SpringBootApplication

public class Pa2U3P4DllYfApplication implements CommandLineRunner {

	@Autowired
	private IEstudianteService iEstudianteService;
	
	@Autowired
	private IMateriaService iMateriaService;
	
	@Autowired
	private IMatriculaService iMatriculaService;
	
	@Autowired
	private ICuentaBancariaService iCuentaBancariaService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4DllYfApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		TransactionSynchronizationManager.isActualTransactionActive();
		System.out.println("Main: "+TransactionSynchronizationManager.isActualTransactionActive());
		
		CuentaBancaria cuentaBancaria1= new CuentaBancaria();
		cuentaBancaria1.setNumero("1243");
		cuentaBancaria1.setPropietario(null);
		cuentaBancaria1.setSaldo(new BigDecimal(1000));
		cuentaBancaria1.setTipo("A");
		
		this.iCuentaBancariaService.agregar(cuentaBancaria1);
	}

}
