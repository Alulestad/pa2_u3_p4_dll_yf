package com.example.demo.banco.repo.modelo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Component
@Entity
@Table(name = "semestre", schema = "public")
public class Semestre {
	
	@Id
	@GeneratedValue(generator = "seq_semestre", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_semestre", sequenceName = "seq_semestre", allocationSize = 1)
	@Column(name = "smst_id")
	private Integer id;
	@Column(name = "smst_numero")
	private Integer numero;
	@Column(name = "smst_periodo")
	private String periodo;
	@Column(name = "smst_fecha_inicio")
	private LocalDateTime fechaInicio;
	
	@OneToMany(mappedBy = "semestre",cascade = CascadeType.ALL)
	private List<Materia> materias;

	//gets y sets
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public LocalDateTime getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDateTime fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public List<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}

	@Override
	public String toString() {
		return "Semestre [id=" + id + ", numero=" + numero + ", periodo=" + periodo + ", fechaInicio=" + fechaInicio
				+ "]";
	}
	
	

}
