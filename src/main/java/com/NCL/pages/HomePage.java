package com.NCL.pages;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author saran
 *	Declared the loop to validate if the pop up is present 
 *	if present will close the pop up and look for the shore excursions link
 *	Click on the link to navigate to the shore excursions page
 */
public class HomePage {

	private ChromeDriver driver;
	private Properties prop;
	
	public HomePage(ChromeDriver driver, Properties prop) {
		this.driver = driver;
		this.prop = prop;
	}

	public void openNCL() {
		// opening the NCL web page
		driver.navigate().to("https://www.ncl.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// Validating for welcome to NCL pop up
		if (driver.findElementsByXPath((String) prop.get("welcome_popup")).size() > 0) {
			WebElement close = driver.findElement(By.xpath((String) prop.get("close_popup")));
			close.click();
		}
	}

	public void navigateToShoreExcursionPage() {
		// Navigate to shore Excursions
		driver.findElementByXPath((String) prop.getProperty("shore_excursions")).click();
	}

}
