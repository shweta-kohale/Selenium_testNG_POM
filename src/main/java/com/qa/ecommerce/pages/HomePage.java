package com.qa.ecommerce.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

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
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.presenceOfElementLocated(myAccount)).getText();
		//return driver.findElement(myAccount).getText();
	}
	
	public LoginPage doClickLoginLink() {
		driver.findElement(myAccount).click();
		driver.findElement(login).click();
		return new LoginPage(driver);
	}
	
}
