package pageObjects;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class GiftsCardPage extends BasePage{

	public GiftsCardPage(WebDriver driver) 
	{
		super(driver);
		
	}
	@FindBy(xpath="//a[@class='featuredLinksBar__link' and text()=' Gift Cards ']") 
	WebElement giftCard;
	@FindBy(xpath="//h2[@class='_FCNL' and contains(text(),'First')]") 
	WebElement text;
	@FindBy(xpath="//h3[contains(text(),'Birthday')]") 
	WebElement birthday;
	@FindBy(id="ip_2251506436") 
    WebElement amount;
    @FindBy(xpath="//div[@class='_3PNvG']//select[1]") 
    WebElement mon;
    @FindBy(xpath="//div[@class='_3PNvG']//select[2]") 
    WebElement dy;
    @FindBy(xpath="//button[text()='Next']") 
    WebElement next;
    
    @FindBy(xpath="//input[@id='ip_4036288348']") 
	 WebElement recipientName;
    @FindBy(name="recipient_email") 
    WebElement recipientEmail;
    @FindBy(name="recipient_mobile_number") 
    WebElement recipientMobile;
    @FindBy(name="customer_name") 
    WebElement senderName;
    @FindBy(name="customer_email") 
    WebElement senderEmail;
    @FindBy(name="customer_mobile_number") 
    WebElement senderMobile;
    @FindBy(name="customer_address") 
    WebElement senderAddress;
    @FindBy(name="zip") 
    WebElement senderPinCode;
    @FindBy(name="message")
    WebElement message;
    @FindBy(xpath="//button[@class='_3Hxyv _1fVSi action-button _1gIUf _1XfDi\']") 
    WebElement submit;
    @FindBy(xpath="//div[@class='_1HVuH']") 
    WebElement pinError;
	
	public void clickBirthday() {
		js.executeScript("arguments[0].scrollIntoView();",text);
		birthday.click();
		
	}
	public void enterAmount(String amt) throws InterruptedException {
	   	  Thread.sleep(2000);
	   	  amount.sendKeys(amt);  
	     }
	public void setDate() 
	{
	   	LocalDate date=LocalDate.now().plusDays(1);
	    String  day=String.valueOf(date.getDayOfMonth());
		String month=date.getMonth().toString();
		int year=date.getYear();
		Select s1=new Select(dy);
		s1.selectByVisibleText(day);
		String m=month.substring(0,1)+month.substring(1, 3).toLowerCase()+" ("+year+")";
		Select s=new Select(mon);
		s.selectByVisibleText(m);
	 }
	 public void clickNext() throws InterruptedException
	 {
	   	  Thread.sleep(2000);
	   	  next.click();
	 }
	 public void fillDetails(String recName,String recEmail,String recMobile,String senName,String senEmail,String senMobile,String senAddress,String senPinCode) throws InterruptedException 
	 {	 
			 recipientName.clear();
			 recipientName.sendKeys(recName);
			 recipientEmail.clear();
	   	     recipientEmail.sendKeys(recEmail);
	   	     recipientMobile.clear();
	   	     recipientMobile.sendKeys(recMobile.substring(1, recMobile.length()-1));
	   	     senderName.clear();
	   	     senderName.sendKeys(senName);
	   	     senderEmail.clear();
	   	     senderEmail.sendKeys(senEmail);
	   	     senderMobile.clear();
	   	     senderMobile.sendKeys(senMobile.substring(1, senMobile.length()-1));
	   	     senderAddress.clear();
	   	     senderAddress.sendKeys(senAddress);
	   	     senderPinCode.clear();
	   	     senderPinCode.sendKeys(senPinCode.substring(1,senPinCode.length()-1));
	   	     message.clear();
	   	     message.sendKeys("Happy Birthday!!!");
	   	     Thread.sleep(2000);
	   	     submit.click();
	   }
	public void captureErrorMessage() {
	   	  //boolean x=true;
	   	  try {
	   		  
	   	  if(!(recipientEmail.getAttribute("validationMessage").equals(""))) {
	   		  System.out.println(recipientEmail.getAttribute("validationMessage"));
	   	  }
	   	  else if(!(recipientMobile.getAttribute("validationMessage").equals(""))) {
	   		  System.out.println(recipientMobile.getAttribute("validationMessage")+" of mobile number");
	   	  }
	   	  else if(!(senderEmail.getAttribute("validationMessage").equals(""))) {
	   		  System.out.println(senderEmail.getAttribute("validationMessage"));
	   	  }
	   	  else if(!(senderMobile.getAttribute("validationMessage").equals(""))) {
	   		  System.out.println(senderMobile.getAttribute("validationMessage")+" of mobile number");
	   	  }
	   	  else if(pinError.isDisplayed()) {
	   		  System.out.println(pinError.getText());
	   	  }
	   	  
	   	  }
	   	  catch(Exception e) {
	   		  System.out.println("All Details filled correctly");
	   	  }

	}
	public void takeScreenShot() throws IOException
	{
	TakesScreenshot screenshot = (TakesScreenshot)driver;
	//Saving the screenshot in desired location
	File source = screenshot.getScreenshotAs(OutputType.FILE);
	//Path to the location to save screenshot
	FileUtils.copyFile(source, new File(".\\screenshot\\screenshots.png"));
	//System.out.println("Screenshot is captured");
	}
	
    
    
}
