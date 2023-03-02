package com.qa.ecommerce.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductDetailsPage {
	
	private WebDriver driver;
	private By metaData = By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[position()=1]//li");
	private Map<String,String> productData;
	
	public ProductDetailsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getProductHeaderName(String productName) {
		By product = By.xpath("//h1[text()='"+productName+"']");
		return driver.findElement(product).getText();
	}
	
	public String getProductDetailsPageTitle() {
		return driver.getTitle();
	}
	
	public boolean getProductDetailsPageURL(String productName) {
		String url = driver.getCurrentUrl();
		if(url.contains(productName)) {
			return true;
		}
		else {
			return false;
		}
	}

	public Map<String,String> getProductMetaData() {
		List<WebElement> productMetaData = driver.findElements(metaData);
		productData = new HashMap<String, String>();
		
		for(WebElement e : productMetaData ) {
			String text = e.getText();
			String data[] = text.split(":");
			String dataKey = data[0].trim();
			System.out.println("dataKey"+dataKey);
			
			String dataValue = data[1].trim();
			System.out.println("dataValue"+dataValue);
			productData.put(dataKey, dataValue);
		}
		System.out.println("ProductData:"+productData);
		return productData;
	}
}
