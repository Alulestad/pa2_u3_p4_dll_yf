package com.example.demo.banco.repo;

import java.util.List;

import com.example.demo.banco.repo.modelo.Transferencia;

public interface ITransferenciaRepo {
	
	public void insertar(Transferencia transferencia);
	public List<Transferencia> seleccionarTodos();
}
