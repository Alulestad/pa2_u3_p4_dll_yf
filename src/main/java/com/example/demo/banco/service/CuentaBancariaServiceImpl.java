package com.example.demo.banco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.demo.banco.repo.ICuentaBancariaRepo;
import com.example.demo.banco.repo.modelo.CuentaBancaria;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class CuentaBancariaServiceImpl implements ICuentaBancariaService {

	@Autowired
	private ICuentaBancariaRepo iCuentaBancariaRepo;
	
	@Autowired
	private IPruebaService iPruebaService;
	
	@Override
	@Transactional
	public void agregar(CuentaBancaria cuentaBancaria) {
		System.out.println("Service: "+TransactionSynchronizationManager.isActualTransactionActive());
		this.iCuentaBancariaRepo.insertar(cuentaBancaria);
		//this.iPruebaService.prueba();
		//this.iPruebaService.prueba2();
		//this.iPruebaService.pruebaSupports();
		//this.iPruebaService.pruebaNotSupported();
		//this.iPruebaService.pruebaRequired();
		this.iPruebaService.pruebaRequiresNew();
		//
	}

	@Transactional(value = TxType.NEVER)
	public void prueba() {
		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());

		System.out.println("metodo de pureba");
	}
	
	
	@Override
	public CuentaBancaria buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.iCuentaBancariaRepo.seleccionarPorId(id);
	}

	@Override
	public void actualizar(CuentaBancaria cuentaBancaria) {
		// TODO Auto-generated method stub
		this.iCuentaBancariaRepo.actualizar(cuentaBancaria);
	}



}
