package com.example.demo.banco.service;

import java.math.BigDecimal;
import java.util.List;

import com.example.demo.banco.repo.modelo.Transferencia;

public interface ITransferenciaService {

	public void transferir(Integer idCuentaOrigen,Integer idCuentaDestino,BigDecimal monto);
	public List<Transferencia> reporte();
}
