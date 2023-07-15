package com.example.demo.banco.repo.modelo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Component
@Entity
@Table(name = "cuenta_bancaria")
public class CuentaBancaria {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cuenta_bancaria")
	@SequenceGenerator(name = "seq_cuenta_bancaria",sequenceName = "seq_cuenta_bancaria",allocationSize = 1)
	@Column(name = "cuba_id")
	private Integer id;
	@Column(name = "cuba_numero")
	private String numero;
	@Column(name = "cuba_saldo")
	private BigDecimal saldo;
	@Column(name = "cuba_tipo")
	private String tipo; //A o C

	// id_propietario

	/*
	 * 1un metodo para guardar cuentaBancaria 
	 * 2do método realizar la transferencia. Recibe: numeroCuentaOrigen, numeroCuentaDestino, monto 
	 * 3ro reporte de todas las transferencias
	 */
}
