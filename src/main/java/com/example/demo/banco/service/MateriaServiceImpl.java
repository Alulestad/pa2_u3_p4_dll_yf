package com.example.demo.banco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.banco.repo.IMateriaRepo;
import com.example.demo.banco.repo.modelo.Materia;

@Service
public class MateriaServiceImpl implements IMateriaService {

	@Autowired
	private IMateriaRepo iMateriaRepo;
	
	@Override
	public void agregar(Materia materia) {
		this.iMateriaRepo.insertar(materia);

	}

}
