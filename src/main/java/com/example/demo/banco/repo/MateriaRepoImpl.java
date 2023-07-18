package com.example.demo.banco.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.banco.repo.modelo.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MateriaRepoImpl implements IMateriaRepo {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Materia materia) {
		this.entityManager.persist(materia);

	}

	@Override
	public Materia seleccionarPorCodigo(String codigo) {
		
		TypedQuery<Materia> myQuery=this.entityManager
				.createQuery("select m from Materia m where m.codigo=:datoCodigo", Materia.class);
		
		myQuery.setParameter("datoCodigo", codigo);
		List<Materia>  materias= myQuery.getResultList();
		//******
		return materias.get(0);
	}

}
