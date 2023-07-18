package com.example.demo.banco.repo.modelo;

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
@Table(name = "provincia", schema = "public")
public class Provincia {

	@Id
	@GeneratedValue(generator = "seq_provincia", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_provincia", sequenceName = "seq_provincia", allocationSize = 1)
	@Column(name = "prov_id")
	private Integer id;
	@Column(name = "prov_codigo")
	private String codigo;
	@Column(name = "prov_nombre")
	private String nombre;
	@Column(name = "prov_capital")
	private String capital;

	
	//gets y sets
	@OneToMany(mappedBy = "provincia", cascade = CascadeType.ALL)
	private List<Estudiante> estudiantes;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}


	public List<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	@Override
	public String toString() {
		return "Provincia [id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + ", capital=" + capital + "]";
	}

}
