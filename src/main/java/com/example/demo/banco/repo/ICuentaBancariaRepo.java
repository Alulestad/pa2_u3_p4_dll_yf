package com.example.demo.banco.repo;

import com.example.demo.banco.repo.modelo.CuentaBancaria;

public interface ICuentaBancariaRepo {
	public void insertar(CuentaBancaria cuentaBancaria);
	
	public CuentaBancaria seleccionarPorId(Integer id);
	
	public void actualizar(CuentaBancaria cuentaBancaria);

	void insertarAsync(CuentaBancaria cuentaBancaria);
}
