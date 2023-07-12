package com.example.demo.banco.service;

import java.util.List;

import com.example.demo.banco.repo.modelo.Habitacion;
import com.example.demo.banco.repo.modelo.Hotel;

public interface IHotelService {

	public List<Hotel> buscarInnerJoin();
	
	public List<Hotel> buscarOuterRightJoin();
	
	public List<Hotel> buscarOuterLeftJoin();
	
	public List<Habitacion> buscarHabitacionOuterLeftJoin();
	
	public List<Hotel> buscarOuterFullJoin();
	
	public List<Hotel> buscarWhereJoin();
}
