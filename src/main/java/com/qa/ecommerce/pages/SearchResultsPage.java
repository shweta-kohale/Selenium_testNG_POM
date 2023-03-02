package com.qa.ecommerce.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.ecommerce.constants.AppConstants;


public class SearchResultsPage {
	private WebDriver driver;
	private By productSearch = By.cssSelector("div.product-layout");
	
	public SearchResultsPage (WebDriver driver) {
		this.driver = driver;
		
	}
	
	public Boolean isSearchSuccessful() {
		List<WebElement> searchList = driver.findElements(productSearch);
		System.out.println("searchList.size()"+searchList.size());
		if(searchList.size() > 0) {
			System.out.println("Products are found");
			return true;
		}
		else {
			return false;
		}
	}
	
	public ProductDetailsPage selectProduct(String productName) {
		By product = By.linkText(productName);
		driver.findElement(product).click();
		return new ProductDetailsPage(driver);
	}
	

}
