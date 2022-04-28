package com.testBuk.test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.testBuk.base.BaseConfig;
import com.testBuk.dataprovider.IntegratedDataProvider;
import com.testBuk.entidades.Usuario;
import com.testBuk.page.Login;

public class IniciarSesion extends BaseConfig {
	@Test(description = "Realizar Inicio de Sesion", dataProvider = "buscar", dataProviderClass = IntegratedDataProvider.class)
	public void InicioSesion(Usuario usuario) throws InterruptedException {
		SoftAssert soft = new SoftAssert();
		Login logIn = new Login(driver);
		soft.assertTrue(logIn.login(usuario), "Inicio de sesion correcto");
		soft.assertTrue(logIn.alert(), "Inicio de sesión correcto");
		soft.assertAll();
	}
}