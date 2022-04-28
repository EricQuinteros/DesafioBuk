package com.testBuk.page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.testBuk.base.BaseConfig;
import com.testBuk.entidades.Usuario;

public class Home extends BaseConfig{
	
	public Home(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "signin2")
	public WebElement btnSignUp;
	
	@FindBy(id = "sign-username")
	public WebElement txtNombre;

	@FindBy(id = "sign-password")
	public WebElement txtPassword;
	
	@FindBy(xpath = "//button[@class=\"btn btn-primary\"][text()='Sign up']")
	public WebElement btnSignup;
	
	
	public boolean signUp (Usuario usuario) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 3);
			wait.until(ExpectedConditions.elementToBeClickable(btnSignUp));
			btnSignUp.click();
			txtNombre.sendKeys(usuario.getNombre());
			txtPassword.sendKeys(usuario.getPassword());
			btnSignup.click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean alert () {
		try {
		Alert simpleAlert = driver.switchTo().alert();
	    String alertText = simpleAlert.getText();
	    System.out.println("Alert text is " + alertText);
	    simpleAlert.accept();
	    return false;
	} catch (Exception e) {
		e.printStackTrace();
		return true;
	}
	}
}