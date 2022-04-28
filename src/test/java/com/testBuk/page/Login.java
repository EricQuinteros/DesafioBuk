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

public class Login extends BaseConfig{
	
	public Login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "login2")
	public WebElement btnLinkLogin;
	
	@FindBy(id = "loginusername")
	public WebElement txtUser;

	@FindBy(id = "loginpassword")
	public WebElement txtPass;
	
	@FindBy(xpath = "//button[@class=\"btn btn-primary\"][text()='Log in']")
	public WebElement btnLogin;
	
	
	public boolean login (Usuario usuario) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 3);
			wait.until(ExpectedConditions.elementToBeClickable(btnLinkLogin));
			btnLinkLogin.click();
			txtUser.sendKeys(usuario.getNombre());
			txtPass.sendKeys(usuario.getPassword());
			btnLogin.click();			
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