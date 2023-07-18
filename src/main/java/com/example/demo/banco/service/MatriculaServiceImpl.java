package com.example.demo.banco.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.banco.repo.IEstudianteRepo;
import com.example.demo.banco.repo.IMateriaRepo;
import com.example.demo.banco.repo.IMatriculaRepo;
import com.example.demo.banco.repo.modelo.Estudiante;
import com.example.demo.banco.repo.modelo.Materia;
import com.example.demo.banco.repo.modelo.Matricula;

@Service
public class MatriculaServiceImpl implements IMatriculaService {

	@Autowired
	private IMateriaRepo iMateriaRepo;
	
	@Autowired
	private IEstudianteRepo iEstudianteRepo;
	
	@Autowired
	private IMatriculaRepo iMatriculaRepo;
	
	@Override
	public void matricular(String cedula, List<String> codigo) {
		Estudiante estudiante=this.iEstudianteRepo.seleccionarPorCedula(cedula);
		List<Materia> materiasList=new ArrayList<>();
		
		List<Matricula> matriculas= new ArrayList<>();
		
		estudiante.setMatriculas(matriculas);
		
		for(String cod:codigo) {
			Materia materiaTemporal=this.iMateriaRepo.seleccionarPorCodigo(cod);
			materiaTemporal.setMatriculas(matriculas);
			materiasList.add(materiaTemporal);
		}
		
		
		
		String codigoMatricula=String.valueOf(Math.random()*100000);
		for(Materia mat:materiasList) {
			Matricula matricula= new Matricula();
			matricula.setCodigo(codigoMatricula);
			matricula.setEstudiante(estudiante);
			matricula.setFecha(LocalDateTime.now());
			matricula.setMateria(mat);
			matricula.setValor(new BigDecimal(0));
			
			matriculas.add(matricula);
			
			
			
		}
		
		this.iMatriculaRepo.insertar(matriculas.get(0));

		
		
	
		
	}

}
