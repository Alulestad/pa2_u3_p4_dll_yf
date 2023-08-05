package com.example.demo.banco.service;

import com.example.demo.banco.repo.modelo.CuentaBancaria;

public interface ICuentaBancariaService {
	
	public void agregar(CuentaBancaria cuentaBancaria);
	
	public String agregar2(CuentaBancaria cuentaBancaria);

	public CuentaBancaria buscarPorId(Integer id);
	
	public void actualizar(CuentaBancaria cuentaBancaria);
}
