package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	@FindBy(xpath="//div[ contains(text(),'Explore Our Furniture Range')]")
	WebElement scroll;
	@FindBy(xpath="//h4[contains(text(),'Bookshelves')]")
	WebElement bookshelves;
	
	@FindBy(xpath="//*[@id='header']/section/div/ul[2]/li[3]/a")
	WebElement giftsCard;
	
	public void scrollDown()
	{
		scroll.getText();
	}

	public void clickBookshelves()
	{
		bookshelves.click();
	}
	public void clickgiftsCard()
	{
		giftsCard.click();
	}

}
