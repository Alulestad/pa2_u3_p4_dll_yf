package com.example.demo.banco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.banco.repo.IHotelRepo;
import com.example.demo.banco.repo.modelo.Habitacion;
import com.example.demo.banco.repo.modelo.Hotel;

@Service
public class HotelServiceImpl implements IHotelService {
	
	@Autowired
	private IHotelRepo iHotelRepo;

	@Override
	public List<Hotel> buscarInnerJoin() {
		// TODO Auto-generated method stub
		return this.iHotelRepo.seleccionarInnerJoin();
	}

	@Override
	public List<Hotel> buscarOuterRightJoin() {
		// TODO Auto-generated method stub
		return this.iHotelRepo.seleccionarOuterRightJoin();
	}

	@Override
	public List<Hotel> buscarOuterLeftJoin() {
		// TODO Auto-generated method stub
		return this.iHotelRepo.seleccionarOuterLeftJoin();
	}

	@Override
	public List<Habitacion> buscarHabitacionOuterLeftJoin() {
		// TODO Auto-generated method stub
		return this.iHotelRepo.seleccionarHabitacionOuterLeftJoin();
	}

	@Override
	public List<Hotel> buscarOuterFullJoin() {
		// TODO Auto-generated method stub
		return this.iHotelRepo.seleccionarOuterFullJoin();
	}

	@Override
	public List<Hotel> buscarWhereJoin() {
		// TODO Auto-generated method stub
		return this.iHotelRepo.seleccionarWhereJoin();
	}
	
	
	
	


	
}
