package com.example.demo.funcional;

public class PersonaSupplierImpl implements IPersonaSupplier<String> {

	@Override
	public String getId() {

		String cedula="17123456789";
		cedula=cedula+"zzzzzzzz";
		return cedula;
	}

}
