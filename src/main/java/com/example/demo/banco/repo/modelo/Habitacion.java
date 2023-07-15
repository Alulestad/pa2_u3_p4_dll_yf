package com.example.demo.banco.repo.modelo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Component
@Table(name = "habitacion", schema = "public")
@Entity
public class Habitacion {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_habitacion")
	@SequenceGenerator(name = "seq_habitacion", sequenceName = "seq_habitacion", allocationSize = 1)
	@Column(name = "habi_id")
	private Integer id;
	@Column(name = "habi_numero")
	private String numero;
	@Column(name = "habi_valor")
	private BigDecimal valor;

	@Transient
	private BigDecimal valorIncluidoIva;

	@ManyToOne()
	@JoinColumn(name = "habi_id_hotel")
	private Hotel hotel;

	// Get y sets
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

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public BigDecimal getValorIncluidoIva() {
		return valorIncluidoIva;
	}

	public void setValorIncluidoIva(BigDecimal valorIncluidoIva) {
		this.valorIncluidoIva = valorIncluidoIva;
	}

	@Override
	public String toString() {
		return "Habitacion [id=" + id + ", numero=" + numero + ", valor=" + valor + "]";
	}

}
