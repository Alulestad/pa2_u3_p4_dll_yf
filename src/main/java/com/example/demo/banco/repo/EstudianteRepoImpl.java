package com.example.demo.banco.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.banco.repo.modelo.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EstudianteRepoImpl implements IEstudianteRepo {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Estudiante estudiante) {
		this.entityManager.persist(estudiante);

	}

	@Override
	public Estudiante seleccionarPorCedula(String cedula) {
		
		TypedQuery<Estudiante> myQuery=this.entityManager
				.createQuery("select e from Estudiante e where e.cedula=:datoCedula", Estudiante.class);
		myQuery.setParameter("datoCedula", cedula);
		List<Estudiante>  estudiantes= myQuery.getResultList();
		//******
		
		return estudiantes.get(0);
	}
	
	

}
