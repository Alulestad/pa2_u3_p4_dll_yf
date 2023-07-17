package com.example.demo.banco.repo.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
import jakarta.persistence.Transient;

@Component
@Entity
@Table(name = "transferencia", schema = "public")
public class Transferencia {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_transferencia")
	@SequenceGenerator(name = "seq_transferencia", sequenceName = "seq_transferencia", allocationSize = 1)
	@Column(name = "tran_id")
	private Integer id;
	@Column(name = "tran_fecha")
	private LocalDateTime fecha;
	@Column(name = "tran_nonto")
	private BigDecimal nonto;
	@Column(name = "tran_id_cta_destino")
	private Integer idCtaDestinio;

	// id_cta_origen
	// id_cta_destino

	@ManyToOne( fetch = FetchType.LAZY)
	@JoinColumn(name = "tran_id_cta_origen")
	private CuentaBancaria cuentaBancaria;

	//gets y sets
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getNonto() {
		return nonto;
	}

	public void setNonto(BigDecimal nonto) {
		this.nonto = nonto;
	}

	public Integer getIdCtaDestinio() {
		return idCtaDestinio;
	}

	public void setIdCtaDestinio(Integer idCtaDestinio) {
		this.idCtaDestinio = idCtaDestinio;
	}

	public CuentaBancaria getCuentaBancaria() {
		return cuentaBancaria;
	}

	public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
	}

	@Override
	public String toString() {
		return "Transferencia [id=" + id + ", fecha=" + fecha + ", nonto=" + nonto + ", idCtaDestinio=" + idCtaDestinio
				+ "ID Cuenta Origen="+cuentaBancaria.getId()+"]";
	}

}
