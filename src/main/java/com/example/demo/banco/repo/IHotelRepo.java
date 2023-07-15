package com.example.demo.banco.repo;

import java.util.List;

import com.example.demo.banco.repo.modelo.Habitacion;
import com.example.demo.banco.repo.modelo.Hotel;

public interface IHotelRepo {

	// create, read, update delete
	
	public void insertar(Hotel hotel);
	
	public List<Hotel> seleccionarInnerJoin();
	
	public List<Hotel> seleccionarOuterRightJoin();
	
	public List<Hotel> seleccionarOuterLeftJoin();
	
	public List<Habitacion> seleccionarHabitacionOuterLeftJoin();
	
	public List<Hotel> seleccionarOuterFullJoin();
	
	public List<Hotel> seleccionarWhereJoin();
	
	public List<Hotel> seleccionarFetchJoin();
	
	
}
