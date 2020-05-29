package com.newtours;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class NewTourRegistration
{
	static WebDriver driver;
	public void print()
	{
		List<WebElement> options = driver.findElements(By.xpath("//select[@name='country']"));
		System.out.println("Capture all dropdown values:");
		for (int i=0; i<= options.size()-1;i++)
		{
			System.out.println(options.get(i).getText());
		}
	}
	public static void main(String[] args) throws IOException, InterruptedException
	{
		XSSFWorkbook wb = new XSSFWorkbook (new FileInputStream(".//screenshot//InputSheet.xlsx"));
		XSSFSheet Datasheet = wb.getSheet("Registration_Data");
		int rowCount=Datasheet.getLastRowNum();
		System.out.println(rowCount);

WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				driver.get("http://demo.guru99.com/test/newtours/register.php");
				driver.manage().window().maximize();
				WebDriverWait wait = new WebDriverWait(driver,30);
				try {
		for (int j=1; j<=rowCount;j++)
		{
			Row row = Datasheet.getRow(j);
				String firstName =row.getCell(0).getStringCellValue();
				String lastname = row.getCell(1).getStringCellValue();
			    String phone = row.getCell(2).getStringCellValue();
				String userName = row.getCell(3).getStringCellValue();
				String address1 = row.getCell(4).getStringCellValue();
				String city = row.getCell(5).getStringCellValue();
				String state = row.getCell(6).getStringCellValue();
				String postalCode = row.getCell(7).getStringCellValue();
				String email = row.getCell(8).getStringCellValue();
				String password = row.getCell(9).getStringCellValue();
				String confirmPassword = row.getCell(10).getStringCellValue();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='firstName']")));
				driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(firstName);
				driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(lastname);
				driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(phone);
				driver.findElement(By.xpath("//input[@id='userName']")).sendKeys(userName);
				driver.findElement(By.xpath("//input[@name='address1']")).sendKeys(address1);
				driver.findElement(By.xpath("//input[@name='city']")).sendKeys(city);
				driver.findElement(By.xpath("//input[@name='state']")).sendKeys(state);
				driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys(postalCode);
				NewTourRegistration obj1=new NewTourRegistration();
				obj1.print();
				driver.findElement(By.xpath("//select[@name='country']")).click();
				//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body//option[108])")));
				driver.findElement(By.cssSelector("tbody:nth-child(1) tr:nth-child(11) td:nth-child(2) select:nth-child(1) > option:nth-child(89)")).click();
				driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
				driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
				driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys(confirmPassword);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='submit']")));
				driver.findElement(By.xpath("//input[@name='submit']")).click();
				Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'sign-in')]")).isEnabled());
				System.out.println("Assert passed, User Successfuly Registered");
				TakesScreenshot scrShot =((TakesScreenshot)driver);
				File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
				File Des = new File(".//screenshot//UserRegisteration"+j+".png");
				FileUtils.copyFile(SrcFile, Des);
				driver.get("http://demo.guru99.com/test/newtours/register.php");
				//driver.wait(20000);
				System.out.println(j);
		}
				}
				catch(Exception e)
				{
					
				}
		driver.close();
	}
	

}