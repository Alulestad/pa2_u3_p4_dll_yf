package com.example.demo.banco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.banco.repo.IEstudianteRepo;
import com.example.demo.banco.repo.modelo.Estudiante;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

	@Autowired
	private IEstudianteRepo iEstudianteRepo;
	
	@Override
	public void agregar(Estudiante estudiante) {
		this.iEstudianteRepo.insertar(estudiante);
	}

}
