package com.example.demo.banco.repo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.demo.banco.repo.modelo.CuentaBancaria;
import com.example.demo.banco.service.CuentaBancariaServiceImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class CuentaBancariaRepoImpl implements ICuentaBancariaRepo {
	public static final Logger LOG= LoggerFactory.getLogger(CuentaBancariaRepoImpl.class);

	
	@PersistenceContext
	private EntityManager entityManager;

	
	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(CuentaBancaria cuentaBancaria) {
		//System.out.println("Repo: "+TransactionSynchronizationManager.isActualTransactionActive());
		LOG.info("Hilo Repository:"+Thread.currentThread().getName());
		this.entityManager.persist(cuentaBancaria);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertarAsync(CuentaBancaria cuentaBancaria) {
		//System.out.println("Repo: "+TransactionSynchronizationManager.isActualTransactionActive());
		LOG.info("Hilo Repository:"+Thread.currentThread().getName());
		this.entityManager.persist(cuentaBancaria);
	}
	
	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public CuentaBancaria seleccionarPorId(Integer id) {
		return this.entityManager.find(CuentaBancaria.class, id);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)//requiried
	public void actualizar(CuentaBancaria cuentaBancaria) {
		this.entityManager.merge(cuentaBancaria);
	}

}
