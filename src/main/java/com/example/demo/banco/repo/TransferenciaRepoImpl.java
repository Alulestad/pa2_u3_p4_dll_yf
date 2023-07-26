package com.example.demo.banco.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.banco.repo.modelo.Transferencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class TransferenciaRepoImpl implements ITransferenciaRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Transferencia> seleccionarTodos() {

		TypedQuery<Transferencia> myQuery = this.entityManager.createQuery("select t from Transferencia t",
				Transferencia.class);

		return myQuery.getResultList();
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Transferencia transferencia) {
		this.entityManager.persist(transferencia);
		//throw new RuntimeException();

	}

}
