package pageObjects;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class BookShelvesPage extends BasePage {
	String firstProduct,secondProduct,thirdProduct;
    String firstProductCost, secondProductCost, thirdProductCost;
	public BookShelvesPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//a[@class='close-reveal-modal hide-mobile']")
	WebElement popup;
	@FindBy(xpath="//div[contains(text(),'Price')]")
	WebElement priceButton;
	@FindBy(xpath="//div[@class='noUi-handle noUi-handle-upper']")
	WebElement slider;
	@FindBy(xpath="//li[@data-group='storage type']")
	WebElement storageType;
	@FindBy(xpath="//input[@value='Open']")
	WebElement open;
	@FindBy(xpath="//input[@id='filters_availability_In_Stock_Only']")
	WebElement stockOnly;
	@FindBy(xpath="//div[@class='product-title product-title-sofa-mattresses']/span")
	List<WebElement> allNames;
	@FindBy(xpath="//div[@class='price-number']/span")
	List<WebElement> prices;
	public void clickPopup()
	{
		popup.click();
	}
	public void clickPrice()
	{
		priceButton.click();
	}
	public void dragSlider() throws InterruptedException
	{
		Actions act=new Actions(driver);
	    act.dragAndDropBy(slider,-274, 0).perform();
	    Thread.sleep(2000);
	}
	public void clickStorageButton()
	{
		storageType.click();
		open.click();
	}
	public void clickStockOnly() throws InterruptedException
	{
		stockOnly.click();
		Thread.sleep(3000);
	}
	public void ShelvesCount() throws InterruptedException
	{
		
	    System.out.println("The total products under 15000 are:"+allNames.size());
	    firstProduct=allNames.get(0).getText();
	    System.out.println(firstProduct);
	    secondProduct=allNames.get(1).getText();
	    System.out.println(secondProduct);
	    thirdProduct=allNames.get(2).getText();
	    System.out.println(thirdProduct);
	    Thread.sleep(3000);
	}
	
	public void displayProducts()
	{
		
		firstProductCost=prices.get(0).getText();
	    System.out.println("The cost of first product is:"+firstProductCost);
	    secondProductCost=prices.get(1).getText();
	    System.out.println("The cost of second product is:"+secondProductCost);
	    thirdProductCost=prices.get(2).getText();
	    System.out.println("The cost of Third product is:"+thirdProductCost);
	}
	public void excelData() throws IOException
	{
		FileOutputStream file=new FileOutputStream(".\\testData\\Output.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet();
		
		XSSFRow r=sheet.createRow(0);
		r.createCell(0).setCellValue("Product name");
		r.createCell(1).setCellValue("Product Cost");
		XSSFRow r1=sheet.createRow(1);
		r1.createCell(0).setCellValue(firstProduct);
		r1.createCell(1).setCellValue(firstProductCost);
		XSSFRow r2=sheet.createRow(2);
		r2.createCell(0).setCellValue(secondProduct);
		r2.createCell(1).setCellValue(secondProductCost);
		XSSFRow r3=sheet.createRow(3);
		r3.createCell(0).setCellValue(thirdProduct);
		r3.createCell(1).setCellValue(thirdProductCost);
		
		workbook.write(file);
		workbook.close();
		file.close();
		
	
	
	}
}
