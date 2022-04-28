package com.testBuk.dataprovider;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.testBuk.entidades.Usuario;

public class IntegratedDataProvider {

	@DataProvider
	public static Object[][] buscar() {
		Gson gson = new Gson();
		Usuario usuario = gson.fromJson(FileDataProvider.asString(String.format("./src/test/resources/data/usuario.json")),
				Usuario.class);
		return new Object[][] { { usuario } };
	}
}
