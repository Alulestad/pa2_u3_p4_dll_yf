package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.demo.banco.repo.ITransferenciaRepo;
import com.example.demo.banco.repo.modelo.CuentaBancaria;
import com.example.demo.banco.repo.modelo.Estudiante;
import com.example.demo.banco.repo.modelo.Habitacion;
import com.example.demo.banco.repo.modelo.Hotel;
import com.example.demo.banco.repo.modelo.Materia;
import com.example.demo.banco.repo.modelo.Propietario;
import com.example.demo.banco.repo.modelo.Provincia;
import com.example.demo.banco.repo.modelo.Semestre;
import com.example.demo.banco.service.ICuentaBancariaService;
import com.example.demo.banco.service.IEstudianteService;
import com.example.demo.banco.service.IHabitacionService;
import com.example.demo.banco.service.IHotelService;
import com.example.demo.banco.service.IMateriaService;
import com.example.demo.banco.service.IMatriculaService;
import com.example.demo.banco.service.IPropietarioService;
import com.example.demo.banco.service.ITransferenciaService;
import com.example.demo.funcional.Main;

import jakarta.transaction.Transactional;

@SpringBootApplication

public class Pa2U3P4DllYfApplication implements CommandLineRunner {

	@Autowired
	private IEstudianteService iEstudianteService;

	@Autowired
	private IMateriaService iMateriaService;

	@Autowired
	private IMatriculaService iMatriculaService;

	@Autowired
	private ITransferenciaService iTransferenciaService;

	@Autowired
	private ICuentaBancariaService iCuentaBancariaService;

	public static final Logger LOG = LoggerFactory.getLogger(Pa2U3P4DllYfApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4DllYfApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		LOG.info("Hilo:" + Thread.currentThread().getName());

//		long tiempoInicial=System.currentTimeMillis();
//		for(int i=0;i<30;i++) {
//			Propietario propietario1=new Propietario();
//			propietario1.setApellido("Molina");
//			propietario1.setCedula("1712341234"+String.valueOf(i));
//			propietario1.setCuentasBancarias(null);
//			propietario1.setNombre("Daniel");
//			
//			CuentaBancaria cuentaBancaria11=new CuentaBancaria();
//			cuentaBancaria11.setNumero(String.valueOf(i));
//			cuentaBancaria11.setPropietario(propietario1);
//			cuentaBancaria11.setSaldo(new BigDecimal(10000));
//			cuentaBancaria11.setTipo("A");
//			
//
//			List<CuentaBancaria> cuentasBancarias1= new ArrayList<>();
//			cuentasBancarias1.add(cuentaBancaria11);
//
//			
//			propietario1.setCuentasBancarias(cuentasBancarias1);
//			
//			this.iCuentaBancariaService.agregar(cuentaBancaria11);
//		}
//		
//		long tiempoFinal=System.currentTimeMillis();
//		long tiempoTranscurrido=(tiempoFinal-tiempoInicial)/1000;
//		LOG.info("Tiempo transcurido: "+(tiempoFinal-tiempoInicial));
//		LOG.info("Tiempo transcurido: "+tiempoTranscurrido);

//		//incio
//		long tiempoInicial=System.currentTimeMillis();
//		List<CuentaBancaria> lista=new ArrayList<>(); 
//		for(int i=0;i<100;i++) {
//			Propietario propietario1=new Propietario();
//			propietario1.setApellido("Molina");
//			propietario1.setCedula("1712341234"+String.valueOf(i));
//			propietario1.setCuentasBancarias(null);
//			propietario1.setNombre("Daniel");
//			
//			CuentaBancaria cuentaBancaria11=new CuentaBancaria();
//			cuentaBancaria11.setNumero(String.valueOf(i));
//			cuentaBancaria11.setPropietario(propietario1);
//			cuentaBancaria11.setSaldo(new BigDecimal(10000));
//			cuentaBancaria11.setTipo("A");
//			
//
//			List<CuentaBancaria> cuentasBancarias1= new ArrayList<>();
//			cuentasBancarias1.add(cuentaBancaria11);
//
//			
//			propietario1.setCuentasBancarias(cuentasBancarias1);
//			
//			lista.add(cuentaBancaria11);
//
//		}
//		
//		lista.parallelStream().forEach(this.iCuentaBancariaService::agregar);
//		
//		
//		
//		//fin
//		long tiempoFinal=System.currentTimeMillis();
//		long tiempoTranscurrido=(tiempoFinal-tiempoInicial)/1000;
//		LOG.info("Tiempo transcurido: "+(tiempoFinal-tiempoInicial));
//		LOG.info("Tiempo transcurido: "+tiempoTranscurrido);

		// incio
		long tiempoInicial = System.currentTimeMillis();
		List<CuentaBancaria> lista = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			Propietario propietario1 = new Propietario();
			propietario1.setApellido("Molina");
			propietario1.setCedula("1712341234" + String.valueOf(i));
			propietario1.setCuentasBancarias(null);
			propietario1.setNombre("Daniel");

			CuentaBancaria cuentaBancaria11 = new CuentaBancaria();
			cuentaBancaria11.setNumero(String.valueOf(i));
			cuentaBancaria11.setPropietario(propietario1);
			cuentaBancaria11.setSaldo(new BigDecimal(10000));
			cuentaBancaria11.setTipo("A");

			List<CuentaBancaria> cuentasBancarias1 = new ArrayList<>();
			cuentasBancarias1.add(cuentaBancaria11);

			propietario1.setCuentasBancarias(cuentasBancarias1);

			lista.add(cuentaBancaria11);

		}


		
		Stream <String> listaStream= lista.parallelStream().map(this.iCuentaBancariaService::agregar2);
		LOG.info("Se guardaron las siguientes cuentas");
		listaStream.forEach(LOG::info);
		
		
		// fin
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;
		LOG.info("Tiempo transcurido: " + (tiempoFinal - tiempoInicial));
		LOG.info("Tiempo transcurido: " + tiempoTranscurrido);

		

	}

}
