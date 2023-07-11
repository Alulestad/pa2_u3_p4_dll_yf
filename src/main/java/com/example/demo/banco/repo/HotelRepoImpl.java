package com.example.demo.banco.repo;

import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.example.demo.banco.repo.modelo.Hotel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class HotelRepoImpl implements IHotelRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Hotel> seleccionarInnerJoin() {
		//SQL
		//SELECT * FROM hotel h inner JOIN habitacion ha on h.hotel_id=ha.habi_id_hotel;
		//JPQL
		//select h from Hotel h join h.habitaciones ha
		//ponemos la relacion que hace la referencia a habitaciones
		TypedQuery<Hotel> myQuery=this.entityManager.createQuery(""
				+ "select h from Hotel h join h.habitaciones ha", Hotel.class);
		
		List<Hotel> hotels= myQuery.getResultList();
		
		hotels.forEach(h->{
			h.getHabitaciones().size();
		});
		
		return hotels;
	}

	
}
