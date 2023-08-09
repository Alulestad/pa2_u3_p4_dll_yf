package com.example.demo.banco.service;

import java.util.concurrent.CompletableFuture;

import com.example.demo.banco.repo.modelo.CuentaBancaria;

public interface ICuentaBancariaService {
	
	public void agregar(CuentaBancaria cuentaBancaria);
	
	public String agregar2(CuentaBancaria cuentaBancaria);

	public CuentaBancaria buscarPorId(Integer id);
	
	public void actualizar(CuentaBancaria cuentaBancaria);
	
	public void agregarAsincrono(CuentaBancaria bancaria);
	
	public CompletableFuture<String> agregarAsincrono2(CuentaBancaria bancaria);
}
