package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class AppUtils
{
	public static WebDriver driver;
    public static String url = "http://orangehrm.qedgetech.com";
    
    
    @BeforeTest
	public static void launchApp()
	
	{
		
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--remote-allow-origins=*");

    	 driver = new ChromeDriver(options);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
	}
	
    @AfterTest
	public static void closeApp()
	
	{
		
		driver.close();
		
	}
		
		
		
		
	
	
	
	
}
