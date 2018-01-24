package pageObjects;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class TrivagoHomePageObjects {
	protected WebDriver driver;
	
	public TrivagoHomePageObjects(WebDriver _driver){
		this.driver = _driver;
	}
	
	@FindBy(name = "sQuery")
	private WebElement searchBox;
	
	@FindBy(xpath="//*[@id='suggestion-10469503']/div/span[1]/mark")
	private WebElement option1;
	
	@FindBy(xpath="//*[@id='js-fullscreen-hero']/div/form/div[3]/div[1]/button")
	private WebElement closeDatePicker;
	
	//@FindBy(id = "mf-select-sortby")
	//private WebElement sortBy;
	
	@FindBy(xpath = "//*[@id='js_item_2036783']/div[1]/div[3]/div/div[1]/h3")
	private WebElement hotelName;
	
	@FindBy(xpath = "//*[@id='js_item_2036783']/div[1]/div[3]/section[2]/div/div[1]/div/strong")
	private WebElement hotelPrice;
	
	@FindBy(xpath = "//*[@id='js_item_2036783']/div[1]/div[3]/section[2]/div/div[2]/button")
	private WebElement viewDealButton;
	
	@FindBy(id ="details-info-hotelname") 
	private WebElement hotelNameNewTab;
	
	@FindBy(id = "detailTopBarPriceId")
	private WebElement hotelPriceNewTab;
	
	public void searchHotelUsingCity(){
		searchBox.sendKeys("Pune");
		option1.click();
		closeDatePicker.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	/*public void sortUsingDistance(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mf-select-sortby")));
		Select sort = new Select(sortBy);
		sort.selectByValue("distance");
	}*/

	public String getHotelName(){
		String _hotelName = " ";
		_hotelName = hotelName.getAttribute("title");
		return _hotelName;
	}
	
	public String getHotelPrice(){	
		String _hotelPrice = "";
		_hotelPrice = hotelPrice.getText();
		String price = _hotelPrice.substring(1);
		return price;
	}
	
	public void switchToNewTab() {
		String parentWindowHandle = driver.getWindowHandle();
		viewDealButton.click();
		Set<String> windowHandles = driver.getWindowHandles();
		for(String windowHandle : windowHandles){
			if(!windowHandle.equals(parentWindowHandle)) {
				driver.switchTo().window(windowHandle);
			}
		}
	}
	
	public String getHotelNameFromNewTab() {
		String _hotelNameNewTab= "";
		for(int i=0;i<=2;i++) 
		{
			try {
				_hotelNameNewTab = hotelNameNewTab.getAttribute("title");
				break;
				} catch(Exception e) {
			  System.out.println(e.getMessage());
			  }
		}
		return _hotelNameNewTab;
	}
	
	public String getHotelPriceFromNewTab() {
		((JavascriptExecutor) driver).executeScript("scroll(300,0)");
		String _hotelPriceNewTab= "";
		_hotelPriceNewTab = hotelPriceNewTab.getText();
		return _hotelPriceNewTab;
	}
	
}