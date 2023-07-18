package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4DllYfApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("UNIDAD 3");
		
		Provincia provincia1= new Provincia();
		provincia1.setCapital("Quito");
		provincia1.setCodigo("17");
		provincia1.setNombre("Pichincha");
		
		Estudiante estu1= new Estudiante();
		estu1.setApellido("Molina");
		estu1.setCedula("171234");
		estu1.setNombre("Daniel");
		estu1.setProvincia(provincia1);
		
		Estudiante estu2= new Estudiante();
		estu2.setApellido("Florez");
		estu2.setCedula("171235");
		estu2.setNombre("Yaniry");
		estu2.setProvincia(provincia1);
		
		List<Estudiante> estudiantes1= new ArrayList<>();
		estudiantes1.add(estu1);
		estudiantes1.add(estu2);
		
		provincia1.setEstudiantes(estudiantes1);
		
		this.iEstudianteService.agregar(estu1);
		
		Semestre semestre1= new Semestre();
		semestre1.setFechaInicio(LocalDateTime.now());
		semestre1.setNumero(1);
		semestre1.setPeriodo("2020-2020");
		
		Materia materia1= new Materia();
		materia1.setCodigo("P1");
		materia1.setCreditos(6);
		materia1.setNombre("Programacion");
		materia1.setSemestre(semestre1);
		
		Materia materia2= new Materia();
		materia2.setCodigo("F1");
		materia2.setCreditos(10);
		materia2.setNombre("Fisica");
		materia2.setSemestre(semestre1);
		
		List<Materia> materias1= new ArrayList<>();
		materias1.add(materia1);
		materias1.add(materia2);
		
		semestre1.setMaterias(materias1);
		
		this.iMateriaService.agregar(materia1);
		
		
		List<String> codigosMaterias=new ArrayList<>();
		for(Materia mater:materias1) {
			codigosMaterias.add(mater.getCodigo());
		}
		
		this.iMatriculaService.matricular(estu1.getCedula(), codigosMaterias);
		
		
	}

}
