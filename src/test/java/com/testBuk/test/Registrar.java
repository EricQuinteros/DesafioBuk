package com.testBuk.test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.testBuk.base.BaseConfig;
import com.testBuk.dataprovider.IntegratedDataProvider;
import com.testBuk.entidades.Usuario;
import com.testBuk.page.Home;

public class Registrar extends BaseConfig {
	@Test(description = "Registrar Nuevo Usuario", dataProvider = "buscar", dataProviderClass = IntegratedDataProvider.class)
	public void registrar(Usuario usuario) throws InterruptedException {
		SoftAssert soft = new SoftAssert();
		Home home = new Home(driver);
		soft.assertTrue(home.signUp(usuario), "Prueba exitosa");
		soft.assertTrue(home.alert(), "Creado nuevo usuario");
		soft.assertAll();
	}
}