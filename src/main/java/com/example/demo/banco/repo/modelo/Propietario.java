package com.example.demo.banco.repo.modelo;

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
@Table(name = "propietario")
public class Propietario {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_propietario")
	@SequenceGenerator(name = "seq_propietario",sequenceName = "seq_propietario",allocationSize = 1)
	@Column(name = "prop_id")
	private Integer id;
	@Column(name = "prop_nombre")
	private String nombre;
	@Column(name = "prop_apellido")
	private String apellido;
	@Column(name = "prop_cedula")
	private String cedula;
	
	//
}
