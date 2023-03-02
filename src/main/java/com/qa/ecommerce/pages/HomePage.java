package com.qa.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HomePage {

	
	//1. locator
	//2. constr
	//3. actions
	
	private WebDriver driver;
	private By myAccount = By.linkText("My Account");
	private By login = By.linkText("Login");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getHomePageTitle() {
		return driver.getTitle();
	}
	
	public String getMyAccountLink() {
		return driver.findElement(myAccount).getText();
	}
	
	public LoginPage doClickLoginLink() {
		driver.findElement(myAccount).click();
		driver.findElement(login).click();
		return new LoginPage(driver);
	}
	
}
