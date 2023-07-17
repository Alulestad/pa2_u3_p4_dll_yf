package com.example.demo.banco.repo.modelo;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Component
@Entity
@Table(name = "cuenta_bancaria", schema = "public")
public class CuentaBancaria {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cuenta_bancaria")
	@SequenceGenerator(name = "seq_cuenta_bancaria", sequenceName = "seq_cuenta_bancaria", allocationSize = 1)
	@Column(name = "cuba_id")
	private Integer id;
	@Column(name = "cuba_numero")
	private String numero;
	@Column(name = "cuba_saldo")
	private BigDecimal saldo;
	@Column(name = "cuba_tipo")
	private String tipo; // A o C

	// id_propietario

	/*
	 * 1un metodo para guardar cuentaBancaria 2do método realizar la transferencia.
	 * Recibe: numeroCuentaOrigen, numeroCuentaDestino, monto 3ro reporte de todas
	 * las transferencias
	 */

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "cuba_id_propietario")
	private Propietario propietario;

	@OneToMany(mappedBy = "cuentaBancariaOrigen", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Transferencia> transferencia1;

	@OneToMany(mappedBy = "cuentaBancariaDestino", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Transferencia> transferencia2;

	// gets y sets
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}

	public List<Transferencia> getTransferencia1() {
		return transferencia1;
	}

	public void setTransferencia1(List<Transferencia> transferencia1) {
		this.transferencia1 = transferencia1;
	}

	public List<Transferencia> getTransferencia2() {
		return transferencia2;
	}

	public void setTransferencia2(List<Transferencia> transferencia2) {
		this.transferencia2 = transferencia2;
	}

	@Override
	public String toString() {
		return "CuentaBancaria [id=" + id + ", numero=" + numero + ", saldo=" + saldo + ", tipo=" + tipo + "]";
	}

}
