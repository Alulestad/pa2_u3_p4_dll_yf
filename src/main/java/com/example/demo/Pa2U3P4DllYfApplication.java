package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

import com.example.demo.banco.repo.modelo.CuentaBancaria;
import com.example.demo.banco.repo.modelo.Propietario;
import com.example.demo.banco.service.ICuentaBancariaService;
import com.example.demo.banco.service.IEstudianteService;
import com.example.demo.banco.service.IMateriaService;
import com.example.demo.banco.service.IMatriculaService;
import com.example.demo.banco.service.ITransferenciaService;

@SpringBootApplication
@EnableAsync // spring
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
		
		long tiempoInicial = System.currentTimeMillis();
		
		List<CompletableFuture<Integer>> listaCompletableEdades=new ArrayList<>();
		for(int i=0;i<10;i++) {
			int yyyy=((int) (Math.random()*2022)) +1;
			int mm=((int) (Math.random()*11))+1;
			int dd=((int) (Math.random()*27))+1;
			LocalDate localDate= LocalDate.of(yyyy, mm, dd);
			listaCompletableEdades.add(iCuentaBancariaService.calcularEdad(localDate));
		}

		
		CompletableFuture.allOf(listaCompletableEdades.get(0),listaCompletableEdades.get(1),
				listaCompletableEdades.get(2),listaCompletableEdades.get(3),
				listaCompletableEdades.get(4),listaCompletableEdades.get(5),
				listaCompletableEdades.get(6),listaCompletableEdades.get(7),
				listaCompletableEdades.get(8),listaCompletableEdades.get(9));
		
		float sumaEdades=0;
		for (CompletableFuture<Integer> cf : listaCompletableEdades) {
			LOG.info("EDAD: "+cf.get());
			sumaEdades=sumaEdades+(float) cf.get();
		}
		float promedio=sumaEdades/listaCompletableEdades.size();
		LOG.info("El promedio de las edades es: "+promedio);
		
		long tiempoFinal = System.currentTimeMillis();
		LOG.info("Tiempo transcurido: " + (tiempoFinal-tiempoInicial));
		
		
		
	}
	

	
	public void codigoBaseAsincrono() throws InterruptedException, ExecutionException {
//		// Asyncrono sin respuesta
//		LOG.info("Hilo Main:" + Thread.currentThread().getName());
//		long tiempoInicial = System.currentTimeMillis();// incio
//		List<CuentaBancaria> lista = new ArrayList<>();
//		for (int i = 0; i < 10; i++) {
//			Propietario propietario1 = new Propietario();
//			propietario1.setApellido("Molina");
//			propietario1.setCedula("1712341234" + String.valueOf(i));
//			propietario1.setCuentasBancarias(null);
//			propietario1.setNombre("Daniel");
//
//			CuentaBancaria cuentaBancaria11 = new CuentaBancaria();
//			cuentaBancaria11.setNumero(String.valueOf(i));
//			cuentaBancaria11.setPropietario(propietario1);
//			cuentaBancaria11.setSaldo(new BigDecimal(10000));
//			cuentaBancaria11.setTipo("A");
//
//			List<CuentaBancaria> cuentasBancarias1 = new ArrayList<>();
//			cuentasBancarias1.add(cuentaBancaria11);
//
//			propietario1.setCuentasBancarias(cuentasBancarias1);
//
//			lista.add(cuentaBancaria11);
//
//			this.iCuentaBancariaService.agregarAsincrono(cuentaBancaria11);
//
//		}
//
//		/*List<String> listFinal = lista.parallelStream().map(this.iCuentaBancariaService::agregar2)
//				.collect(Collectors.toList());*/
//		// LOG.info("Se guardaron las siguientes cuentas");
//		// listFinal.forEach(LOG::info);
//
//		long tiempoFinal = System.currentTimeMillis();// fin
//		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;
//		LOG.info("Tiempo transcurido: " + (tiempoFinal - tiempoInicial));
//		LOG.info("Tiempo transcurido: " + tiempoTranscurrido);
//		LOG.info("Se termino de procesar todo");

		
		LOG.info("###############################################################################");
		// Asyncrono Con respuesta
		LOG.info("Hilo Main:" + Thread.currentThread().getName());
		long tiempoInicial = System.currentTimeMillis();// incio
		List<CompletableFuture<String>> listaRespuesta= new ArrayList<>();
		
		List<CuentaBancaria> lista = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
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

			CompletableFuture<String> respuesta = this.iCuentaBancariaService.agregarAsincrono2(cuentaBancaria11);
			listaRespuesta.add(respuesta);

		}
		
		//Sentencia que espera que termine de procesarse todos los hilos para obtener la respuesta
		//CompletableFuture.allOf(listaRespuesta.get(0),listaRespuesta.get(1),listaRespuesta.get(2)).get();
		CompletableFuture.allOf(listaRespuesta.get(0),listaRespuesta.get(1),listaRespuesta.get(2),listaRespuesta.get(3),listaRespuesta.get(4),listaRespuesta.get(5),listaRespuesta.get(6),listaRespuesta.get(6),listaRespuesta.get(7),listaRespuesta.get(8),listaRespuesta.get(9)).get();

		
		LOG.info("Respuesta 0 del listaRespuesta (Array):" +listaRespuesta.get(0).get());
		LOG.info("Respuesta 0 del listaRespuesta (Array):" +listaRespuesta.get(1).get());
		LOG.info("Respuesta 0 del listaRespuesta (Array):" +listaRespuesta.get(2).get());
		LOG.info("Respuesta 0 del listaRespuesta (Array):" +listaRespuesta.get(3).get());
		LOG.info("Respuesta 0 del listaRespuesta (Array):" +listaRespuesta.get(4).get());
		LOG.info("Respuesta 0 del listaRespuesta (Array):" +listaRespuesta.get(5).get());
		LOG.info("Respuesta 0 del listaRespuesta (Array):" +listaRespuesta.get(6).get());
		LOG.info("Respuesta 0 del listaRespuesta (Array):" +listaRespuesta.get(7).get());
		LOG.info("Respuesta 0 del listaRespuesta (Array):" +listaRespuesta.get(8).get());
		LOG.info("Respuesta 0 del listaRespuesta (Array):" +listaRespuesta.get(9).get());

		
		//si se quita el CompletableFuture.allOf espera que se termine el 1 espera que termine el 2 y así susesivamente. 
		
		
		

		// LOG.info("Se guardaron las siguientes cuentas");
		// listFinal.forEach(LOG::info);

		long tiempoFinal = System.currentTimeMillis();// fin
		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;
		LOG.info("Tiempo transcurido: " + (tiempoFinal - tiempoInicial));
		LOG.info("Tiempo transcurido: " + tiempoTranscurrido);
		LOG.info("Se termino de procesar todo");
		
		
//		LOG.info("#############Respuestas puras del tipo CompletableFuture#############");
//		listaRespuesta.stream().map(String::valueOf).forEach(LOG::info);
//		LOG.info("#############Respuestas en orden de adicion en el list#############");
//		listaRespuesta.stream().map((value)->{
//			try {
//				return value.get();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (ExecutionException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			return String.valueOf(value);
//		}).forEach(LOG::info);
	}

	
	
}
