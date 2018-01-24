package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import pageObjects.TrivagoHomePageObjects;
import testdata.InitializeBrowser;

public class TrivagoTest extends InitializeBrowser{
	@Test
	public void trivagoHotelTest() throws InterruptedException{
		
		TrivagoHomePageObjects trivago = PageFactory.initElements(driver,TrivagoHomePageObjects.class);
		trivago.searchHotelUsingCity();
		//trivago.sortUsingDistance(driver);
		String hotelName = trivago.getHotelName();
		String hotelPrice = trivago.getHotelPrice();
		System.out.println(hotelName);
		System.out.println(hotelPrice);
		trivago.switchToNewTab();
		String hotelNameNewTab = trivago.getHotelNameFromNewTab();
		String hotelPriceNewTab = trivago.getHotelPriceFromNewTab();
		System.out.println(hotelNameNewTab);
		System.out.println(hotelPriceNewTab);
		
		Assert.assertTrue("Hotel Names does not match", hotelName.contains(hotelNameNewTab));
		Assert.assertTrue("Price given on both websites is different", hotelPriceNewTab.equalsIgnoreCase(hotelPrice));
	}
}
