package com.training.base;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.training.config.ConfigFileReader;
public class TestBase {

		private static WebDriver driver;
		private final static String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
		
		public static WebDriver getWebDriver() {
			
			if(driver==null) {
				driver = createLocalDriver();
			}
			return driver;
		}
	@SuppressWarnings("deprecation")
	  private static WebDriver createLocalDriver() {
			System.setProperty(CHROME_DRIVER_PROPERTY, ConfigFileReader.getConfigFileReader().getDriverPath());
			ChromeOptions option = new ChromeOptions();
		//	option.addExtensions(new File("D:\\selenium\\bhghoamapcdpbohphigoooaddinpkbai-6.0.1-Crx4Chrome.com.crx"));
			DesiredCapabilities cap =new DesiredCapabilities();
			cap.setCapability(ChromeOptions.CAPABILITY, option);
			WebDriver driver = new ChromeDriver(cap);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(ConfigFileReader.getConfigFileReader().getImplicitlyWait(), TimeUnit.SECONDS);
			return driver;
		}
			
				
		public static void loadUrl( String url) {
			  if (url==null) {
                    loadUrl();	
                    }
				  else {
					  driver.get(url);  
				  }
		}
		
		public static void loadUrl( ) {
			driver.get(System.getProperty("envUrl"));
				
		}
		
		public static void closeDriver() {
			driver.quit();
			driver =null;
		}
	

}
