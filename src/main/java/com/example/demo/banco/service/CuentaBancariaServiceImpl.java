package com.example.demo.banco.service;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.demo.Pa2U3P4DllYfApplication;
import com.example.demo.banco.repo.ICuentaBancariaRepo;
import com.example.demo.banco.repo.modelo.CuentaBancaria;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class CuentaBancariaServiceImpl implements ICuentaBancariaService {

	public static final Logger LOG= LoggerFactory.getLogger(CuentaBancariaServiceImpl.class);

	@Autowired
	private ICuentaBancariaRepo iCuentaBancariaRepo;
	
	@Autowired
	private IPruebaService iPruebaService;
	
	@Override
	@Transactional
	public void agregar(CuentaBancaria cuentaBancaria) {
		//System.out.println("Service: "+TransactionSynchronizationManager.isActualTransactionActive());
		LOG.info("Hilo Service:"+Thread.currentThread().getName());
		
		
		//Sumas, restas, multiplicaciones, la logica demora 1 segundo.
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.iCuentaBancariaRepo.insertar(cuentaBancaria);
		//this.iPruebaService.prueba();
		//this.iPruebaService.prueba2();
		//this.iPruebaService.pruebaSupports();
		//this.iPruebaService.pruebaNotSupported();
		//this.iPruebaService.pruebaRequired();
		//this.iPruebaService.pruebaRequiresNew();
		
		
		
	}
	
	

	@Override
	@Transactional
	public String agregar2(CuentaBancaria cuentaBancaria) {
		LOG.info("Hilo Service2:"+Thread.currentThread().getName());
		
		
		//Sumas, restas, multiplicaciones, la logica demora 1 segundo.
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.iCuentaBancariaRepo.insertar(cuentaBancaria);
		
		return cuentaBancaria.getNumero();
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
