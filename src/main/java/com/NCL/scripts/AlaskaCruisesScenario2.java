package com.NCL.scripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import com.NCL.pages.HomePage;
import com.NCL.pages.ShoreExcursionPage;

/**
 * @author saranya Ar 
 * Scenario 2 involves the below steps: Open to ncl.com
 *         Navigate to shore excursions page Select Alaska cruises in the
 *         destination drop down and filter the results Validate if Alaska
 *         Cruises is selected under destination If so verify if the filter
 *         options under ports contain only Alaska and British Columbia
 *         
 *         Note: NCL.xlsx can be the input and output data file that can be mapped using POI - XSSFWorkbook 
 *         			Since it was a single scenario have hard coded 
 *         
 */
public class AlaskaCruisesScenario2 {

	private static ChromeDriver driver;
	private static Properties prop;

	public static void main(String[] args) {

		try {
			setup();
			HomePage home = new HomePage(driver, prop);
			home.openNCL();
			home.navigateToShoreExcursionPage();
			ShoreExcursionPage shorePage = new ShoreExcursionPage(driver, prop);
			shorePage.filterAlaskaCruisesResults();
			
			//Output result
			if (shorePage.verifyAlaskaCruiseResults()) {
				if (shorePage.verifyingPortOptions()) {
					System.out.println(
							"Destination is Filtered to Alaska Cruises and Port options contain only Alaska and British Columbia ");
				} else {
					System.err.println("Port contains options other than Alaska and British Columbia");
				}
			} else {
				System.err.println("Destinations not filterd to Alaska Cruises");
			}
			closebrowser();
		} catch (Exception e) {
			System.err.println("Unexpected exception occured while running Scenario 2");
		}

	}

	private static void closebrowser() {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.close();
	}

	private static void setup() throws FileNotFoundException, IOException {
		
		//mapping the properties file to get the xpaths of variable ones
		prop = new Properties();
		InputStream input = new FileInputStream("src/main/resources/config.properties");
		prop.load(input);

		// Declaring the web Browser path and creating an instance of the browser
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\saran\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();

	}

}
