package com.example.demo.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

	private static final Logger LOG = LoggerFactory.getLogger(Main.class); // slf4j

	public static void main(String[] args) {
		IPersona per1 = new PersonaImpl();
		per1.caminar();

		// 1. Supplier
		// Clases:
		IPersonaSupplier<String> supplier1 = new PersonaSupplierImpl();
		LOG.info("Supplier clase: " + supplier1.getId());

		// Lambdas:
		IPersonaSupplier<String> supplier2 = () -> "17123456789";
		LOG.info("Supplier lambda: " + supplier2.getId());

		IPersonaSupplier<String> supplier3 = () -> {
			String cedula = "17123456789";
			cedula = cedula + "zzzzzzzz";
			return cedula;
		};
		LOG.info("Supplier lambda 2: " + supplier3.getId());

	}

}
