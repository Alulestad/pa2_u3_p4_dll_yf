package com.example.demo.banco.service;

import java.util.List;

import com.example.demo.banco.repo.modelo.Materia;

public interface IMatriculaService {
	public void matricular(String cedula, List<String> codigo);
}
