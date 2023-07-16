package com.example.demo.banco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.banco.repo.ICuentaBancariaRepo;
import com.example.demo.banco.repo.modelo.CuentaBancaria;

@Service
public class CuentaBancariaServiceImpl implements ICuentaBancariaService {

	@Autowired
	private ICuentaBancariaRepo iCuentaBancariaRepo;
	
	@Override
	public void agregar(CuentaBancaria cuentaBancaria) {
		this.iCuentaBancariaRepo.insertar(cuentaBancaria);
		
	}



}
