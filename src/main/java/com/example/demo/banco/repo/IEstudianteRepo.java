package com.example.demo.banco.repo;

import com.example.demo.banco.repo.modelo.Estudiante;

public interface IEstudianteRepo {

	
	public void insertar(Estudiante estudiante);
	
	public Estudiante seleccionarPorCedula(	String cedula);
}
