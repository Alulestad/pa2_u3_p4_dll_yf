package com.example.demo.banco.repo;

import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.example.demo.banco.repo.modelo.Habitacion;
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
		// SQL
		// SELECT * FROM hotel h inner JOIN habitacion ha on
		// h.hotel_id=ha.habi_id_hotel;
		// JPQL
		// select h from Hotel h join h.habitaciones ha
		// ponemos la relacion que hace la referencia a habitaciones
		TypedQuery<Hotel> myQuery = this.entityManager
				.createQuery("" + "select h from Hotel h inner join h.habitaciones ha", Hotel.class);

		List<Hotel> hotels = myQuery.getResultList();

		hotels.forEach(h -> {
			h.getHabitaciones().size();
		});

		return hotels;
	}

	@Override
	public List<Hotel> seleccionarOuterRightJoin() {
		// SQL
		// select * from hotel h right join habitacion ha on h.hotel_id=ha.habi_id_hotel

		TypedQuery<Hotel> myQuery = this.entityManager
				.createQuery("" + "select h from Hotel h right join h.habitaciones ha", Hotel.class);

		List<Hotel> hotels = myQuery.getResultList();

		hotels.forEach(h -> {
			if (h != null) {
				h.getHabitaciones().size();
			}
		});

		return hotels;
	}

	@Override
	public List<Hotel> seleccionarOuterLeftJoin() {
		// SQL
		// select * from hotel h left join habitacion ha on h.hotel_id=ha.habi_id_hotel

		TypedQuery<Hotel> myQuery = this.entityManager
				.createQuery("" + "select h from Hotel h left join h.habitaciones ha", Hotel.class);

		List<Hotel> hotels = myQuery.getResultList();

		hotels.forEach(h -> {
			if (h != null) {
				h.getHabitaciones().size();
			}
		});

		return hotels;
	}

	@Override
	public List<Habitacion> seleccionarHabitacionOuterLeftJoin() {
		// SQL
		// select * from hotel h left join habitacion ha on h.hotel_id=ha.habi_id_hotel

		TypedQuery<Habitacion> myQuery = this.entityManager
				.createQuery("" + "select ha from Hotel h left join h.habitaciones ha", Habitacion.class);

		List<Habitacion> habitacions = myQuery.getResultList();
		// System.out.println(habitacions);
		habitacions.forEach(ha -> {
			if (ha != null) {

				// ha.getHotel().toString();
			}
		});

		return habitacions;
	}

	@Override
	public List<Hotel> seleccionarOuterFullJoin() {
		// SQL
		// select * from hotel h full join habitacion ha on h.hotel_id=ha.habi_id_hotel

		TypedQuery<Hotel> myQuery = this.entityManager
				.createQuery("" + "select h from Hotel h full join h.habitaciones ha", Hotel.class);

		List<Hotel> hotels = myQuery.getResultList();

		hotels.forEach(h -> {
			if (h != null) {
				h.getHabitaciones().size();
			}
		});

		return hotels;
	}

	@Override
	public List<Hotel> seleccionarWhereJoin() {
		// SQL
		// select * from hotel h, habitacion ha where h.hotel_id=ha.habi_id_hotel
		// JPQL
		// select h where Hotel h, Habitacion ha where h=ha.hotel
		// Se compara entre objetos ***
		TypedQuery<Hotel> myQuery = this.entityManager
				.createQuery("select h from Hotel h, Habitacion ha where h=ha.hotel ", Hotel.class);

		List<Hotel> hotels = myQuery.getResultList();

		hotels.forEach(h -> {

			h.getHabitaciones().size();

		});

		return hotels;
	}

}
