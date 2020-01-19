package com.NCL.pages;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author saran 
 * On the shore excursions page will select the destinations as
 *         Alaska Cruises And filter to find result Once the results are loaded
 *         will verify if the Alaska cruises is selected under destination
 * 
 */
public class ShoreExcursionPage {

	private ChromeDriver driver;
	private Properties prop;

	public ShoreExcursionPage(ChromeDriver driver, Properties prop) {
		this.driver = driver;
		this.prop = prop;
	}

	public void filterAlaskaCruisesResults() {
		// selecting Alaska cruises in destination
		driver.findElementByXPath("//*[@id=\"search_destinations_chosen\"]/a/span").click();
		driver.findElementByXPath((String) prop.getProperty("alaska_cruises")).click();
		// Clicking on Find Excursions button
		driver.findElementByXPath(
				"//*[@id=\"page-shore-excursions\"]/div/div[1]/div[2]/div/div/div[2]/div[2]/div/button").click();
	}

	public Boolean verifyAlaskaCruiseResults() {
		// TODO Auto-generated method stub
		// Verify if destination is filtered to Alaska
		if (driver.findElementByXPath("//*[@id=\"sap-menu-left\"]/div/div[4]/ul[1]/li[1]/div[2]/ul/li/a/span")
				.isDisplayed()) {
			return true;

		}
		return false;
	}

	public Boolean verifyingPortOptions() {
		// TODO Auto-generated method stub
		// clicking on port to get the filter options
		driver.findElementByXPath("//*[@id=\"sap-menu-left\"]/div/div[4]/ul[1]/li[2]/a/span").click();
		// Verifying if the port options contain only Alaska and BC
		if (driver.findElementByXPath("//*[@id=\"sap-menu-left\"]/div/div[4]/ul[1]/li[2]/div").isDisplayed()) {
			List<WebElement> portsoption = driver.findElementsByXPath("//*[@class=\"listing-wrap\"]/ul/li");
			for (WebElement element : portsoption) {
				String port = element.getText();
				if (port.length() > 0) {
					if (port.contains("Alaska") || port.contains("British Columbia")) {
						continue;
					} else {
						return false;
					}
				}
			}
			return true;
		}
		return false;
	}

}
