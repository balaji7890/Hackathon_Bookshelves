package testCases;

import java.io.IOException;

import org.testng.annotations.Test;


import pageObjects.GiftsCardPage;
import pageObjects.HomePage;
import testBase.BaseClass;
import utilities.ExcelData;

public class TC_002_GiftCard extends BaseClass 
{
	@Test
	public void GiftCardPageData() throws InterruptedException
	{
		HomePage hp=new HomePage(driver);
		hp.clickgiftsCard();
		
		GiftsCardPage gift=new GiftsCardPage(driver);
		gift.clickBirthday();
		
	    gift.enterAmount(p.getProperty("amount"));
		gift.setDate();
		gift.clickNext();
		
	}
		@Test(dataProvider="dp",dataProviderClass=ExcelData.class)
		public void test2(String recipientName,String recipientEmail,String recipientMobile,String senderName,String senderEmail,String senderMobile,String senderAddress,String senderPinCode) throws InterruptedException, IOException {
			GiftsCardPage f=new GiftsCardPage(driver);
			f.fillDetails(recipientName,recipientEmail,recipientMobile, senderName, senderEmail, senderMobile, senderAddress,senderPinCode);
			f.captureErrorMessage();
			f.takeScreenShot();
			//System.out.println("ScreenShot is Captured");
		
	}
		
		

}
