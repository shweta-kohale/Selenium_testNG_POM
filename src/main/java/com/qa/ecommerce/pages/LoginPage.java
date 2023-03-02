package com.qa.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
	private By loginFormText = By.xpath("(//h2)[2]");
	private By email = By.name("email");
	private By password = By.name("password");
	private By loginSubmit = By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input");
	private By forgotPassLink = By.linkText("Forgotten Password");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public String getLoginPageFormText() {
		return driver.findElement(loginFormText).getText();
	}
	
	public Boolean isForgotPasswordLink() {
		return driver.findElement(forgotPassLink).isDisplayed();
	}
	
	public AccountPage doLogin(String userName, String pwd) {
		driver.findElement(email).sendKeys(userName);
		driver.findElement(password).sendKeys(pwd);
		//driver.findElement(loginSubmit).click();
		driver.findElement(loginSubmit).click();
		System.out.println("username"+userName);
		System.out.println("pwd"+pwd);
		return new AccountPage(driver);
	}
}
