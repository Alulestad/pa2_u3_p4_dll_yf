package com.example.demo.banco.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class PruebaServiceImpl implements IPruebaService {

	@Override
	@Transactional(value = TxType.NEVER)
	public void prueba() {
		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
		System.out.println("metodo de prueba");

	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void prueba2() {
		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
		System.out.println("metodo de prueba2");
		
	}

	@Override
	@Transactional(value = TxType.SUPPORTS)
	public void pruebaSupports() {
		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
		System.out.println("metodo de pruebaSupports");
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public void pruebaNotSupported() {
		System.out.println("Metodo pruebaNotSupported: "+TransactionSynchronizationManager.isActualTransactionActive());
		System.out.println("metodo de pruebaNotSupported");
		
	}

	@Override
	@Transactional
	public void pruebaRequired() {
		System.out.println("Metodo pruebaRequired: "+TransactionSynchronizationManager.isActualTransactionActive());
		System.out.println("metodo de pruebaRequired");
		
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void pruebaRequiresNew() {
		System.out.println("Metodo pruebaRequiresNew: "+TransactionSynchronizationManager.isActualTransactionActive());
		System.out.println("metodo de pruebaRequiresNew");
		
	}
	
	
	
	

}
