package com.example.demo.banco.repo.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
@Table(name = "transferencia")
public class Transferencia {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_transferencia")
	@SequenceGenerator(name = "seq_transferencia",sequenceName = "seq_transferencia",allocationSize = 1)
	@Column(name = "tran_id")
	private Integer id;
	@Column(name = "tran_fecha")
	private LocalDateTime fecha;
	@Column(name = "tran_nonto")
	private BigDecimal nonto;
	
	//id_cta_origen
	//id_cta_destino
}
