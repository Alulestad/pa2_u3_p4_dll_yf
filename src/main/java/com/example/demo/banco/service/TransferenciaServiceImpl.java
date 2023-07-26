package com.example.demo.banco.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.banco.repo.ICuentaBancariaRepo;
import com.example.demo.banco.repo.ITransferenciaRepo;
import com.example.demo.banco.repo.modelo.CuentaBancaria;
import com.example.demo.banco.repo.modelo.Transferencia;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class TransferenciaServiceImpl implements ITransferenciaService {

	@Autowired
	private ITransferenciaRepo iTransferenciaRepo;
	
	@Autowired
	private ICuentaBancariaRepo iCuentaBancariaRepo;
	
	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void transferir(Integer idCuentaOrigen,Integer idCuentaDestino,BigDecimal monto) {
		CuentaBancaria cuentaBancariaOrigen=this.iCuentaBancariaRepo.seleccionarPorId(idCuentaOrigen);
		CuentaBancaria cuentaBancariaDestino=this.iCuentaBancariaRepo.seleccionarPorId(idCuentaDestino);
		
		Transferencia transferencia=new Transferencia();
		transferencia.setFecha(LocalDateTime.now());
		transferencia.setCuentaBancariaOrigen(cuentaBancariaOrigen);
		transferencia.setCuentaBancariaDestino(cuentaBancariaDestino);
		transferencia.setNonto(monto);//null=monto
		
		if(monto.compareTo(cuentaBancariaOrigen.getSaldo())<=0) {
			//realizo transferencia
			cuentaBancariaOrigen.setSaldo(cuentaBancariaOrigen.getSaldo().subtract(monto));
			cuentaBancariaDestino.setSaldo(cuentaBancariaDestino.getSaldo().add(monto));
			this.iCuentaBancariaRepo.actualizar(cuentaBancariaOrigen);
			this.iCuentaBancariaRepo.actualizar(cuentaBancariaDestino);
		}else {
			System.out.println("Saldo insuficiente");
			throw new RuntimeException();
		}
		this.iTransferenciaRepo.insertar(transferencia);
		
		//throw new RuntimeException();
		
	}

	@Override
	public List<Transferencia> reporte() {
		return this.iTransferenciaRepo.seleccionarTodos();
	}

}
