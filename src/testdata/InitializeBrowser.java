package testdata;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InitializeBrowser {
	public static WebDriver driver = null;

	@BeforeClass
	public static  void InitializeWebBrowser() {
		System.setProperty("webdriver.chrome.driver", Constant.Driver_Path);
		driver=new ChromeDriver();
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.navigate().to(Constant.Url);	
	}	
	
	@AfterClass
	public static void TearDown(){
		driver.quit();
	}
}