package com.example.demo.funcional;

public class PersonaFunctionImpl implements IPersonaFunction<Integer, String> {

	@Override
	public Integer aplicar(String arg) {
		
		return Integer.valueOf(arg)*10;
	}

	
}
