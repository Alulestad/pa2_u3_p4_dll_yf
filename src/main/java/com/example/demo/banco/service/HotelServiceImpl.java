package com.example.demo.banco.service;

import java.math.BigDecimal;
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
	public void guardar(Hotel hotel) {
		
		
		List<Habitacion> habitacions=hotel.getHabitaciones();
		
		for(Habitacion ha:habitacions) {
			BigDecimal valorIva=ha.getValor().multiply(new BigDecimal(1.12));
			ha.setValorIncluidoIva(valorIva);
		}
		
		
		this.iHotelRepo.insertar(hotel);
	}

	@Override
	public List<Hotel> buscarInnerJoin() {
		return this.iHotelRepo.seleccionarInnerJoin();
	}

	@Override
	public List<Hotel> buscarOuterRightJoin() {
		return this.iHotelRepo.seleccionarOuterRightJoin();
	}

	@Override
	public List<Hotel> buscarOuterLeftJoin() {
		return this.iHotelRepo.seleccionarOuterLeftJoin();
	}

	@Override
	public List<Habitacion> buscarHabitacionOuterLeftJoin() {
		return this.iHotelRepo.seleccionarHabitacionOuterLeftJoin();
	}

	@Override
	public List<Hotel> buscarOuterFullJoin() {
		return this.iHotelRepo.seleccionarOuterFullJoin();
	}

	@Override
	public List<Hotel> buscarWhereJoin() {
		return this.iHotelRepo.seleccionarWhereJoin();
	}

	@Override
	public List<Hotel> buscarFetchJoin() {
		return this.iHotelRepo.seleccionarFetchJoin();
	}

}
