package com.qa.ecommerce.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.ecommerce.constants.AppConstants;

public class AccountPage {

	private WebDriver driver;

	public AccountPage(WebDriver driver) {
		this.driver = driver;
	}

	private By logout = By.linkText("Logout");
	private By search = By.xpath("//input[@name='search']");
	private By searchIcon = By.cssSelector("div#search button");
	private By accountSectionHeader = By.cssSelector("div#content h2");
	private By productSearch = By.cssSelector("div.product-layout");

	public String getAccountPageTitle() {
		
		return driver.getTitle();
	}

	public boolean getAccountPageURL() {
		String url = driver.getCurrentUrl();
		if (url.contains(AppConstants.ACCOUNT_URL)) {
			return true;
		} else
			return false;
	}

	public boolean isLogoutLinkExist() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.presenceOfElementLocated(logout)).isDisplayed();
		//return driver.findElement(logout).isDisplayed();
	}

	public boolean isSearchExist() {
		return driver.findElement(search).isDisplayed();
	}

	public ArrayList<String> getAccountHeaderList() {
		List<WebElement> secHeaderList = driver.findElements(accountSectionHeader);
		ArrayList<String> headerList = new ArrayList<String>();
		for (WebElement e : secHeaderList) {
			String text = e.getText();
			headerList.add(text);
		}
		return headerList;
	}
	
		
	public SearchResultsPage performSearch(String productName) {

		System.out.println("ProductName: " + productName);
		driver.findElement(search).clear();
		driver.findElement(search).sendKeys(productName);
		driver.findElement(searchIcon).click();
		return new SearchResultsPage(driver);
	}
	
	
}
