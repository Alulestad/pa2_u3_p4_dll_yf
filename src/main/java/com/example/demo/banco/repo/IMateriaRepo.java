package com.example.demo.banco.repo;

import com.example.demo.banco.repo.modelo.Materia;

public interface IMateriaRepo {

	public void insertar(Materia materia);
	public Materia seleccionarPorCodigo(String codigo);
	
	
}
