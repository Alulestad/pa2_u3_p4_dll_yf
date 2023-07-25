package com.example.demo.banco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.banco.repo.IPropietarioRepo;
import com.example.demo.banco.repo.modelo.CuentaBancaria;

@Service
public class PropietarioServiceImpl implements IPropietarioService {

	@Autowired
	private IPropietarioRepo iPropietarioRepo;
	


}
