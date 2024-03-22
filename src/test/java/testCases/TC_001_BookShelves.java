package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObjects.BookShelvesPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_BookShelves extends BaseClass {
	@Test
	public void bookShelvesCount() throws InterruptedException, IOException
	{
		HomePage hp=new HomePage(driver);
		hp.scrollDown();
		hp.clickBookshelves();
		
		BookShelvesPage bs=new BookShelvesPage(driver);
		bs.clickPopup();
		bs.clickPrice();
		bs.dragSlider();
		bs.clickStorageButton();
		bs.clickStockOnly();
		bs.ShelvesCount();
		bs.displayProducts();
		bs.excelData();
	}
	

}
