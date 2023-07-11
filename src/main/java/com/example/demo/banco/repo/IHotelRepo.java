package com.example.demo.banco.repo;

import java.util.List;

import com.example.demo.banco.repo.modelo.Hotel;

public interface IHotelRepo {

	// create, read, update delete
	public List<Hotel> seleccionarInnerJoin();
	

}
