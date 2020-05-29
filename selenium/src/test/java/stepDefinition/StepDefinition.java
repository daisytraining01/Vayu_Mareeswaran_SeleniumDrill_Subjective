package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.newtourscucumberframework.Element;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


import javax.imageio.ImageIO;
import javax.xml.ws.Action;

import org.junit.Assert;


public class StepDefinition {
	static WebDriver driver;
	static Element obj;
@Before
	@Given("^Launch Browser$")
	public void launch_Browser()
	{
	WebDriverManager.firefoxdriver().setup();
	driver = new FirefoxDriver();
	}
@Action
	@When("^Get New Tours Login Base URL$")
	public void get_New_Tours_Login_Base_URL()
	{
	driver.get("http://demo.guru99.com/test/newtours/login.php");
	driver.manage().window().maximize();
	}

	@When("^Validate the correctness of Landing Page$")
	public void validate_the_correctness_of_Landing_Page() throws AWTException, IOException
	{
		Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'SIGN-ON')]")).isEnabled());
		System.out.println("Test Case Pass");
		Robot robot1 = new Robot();
		java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle screenRectangle = new Rectangle(screenSize);
        BufferedImage image = robot1.createScreenCapture(screenRectangle);
        File Des = new File(".//screenshot//Sucessful Launch.png");
        ImageIO.write(image, "png", Des);
	}
	
	@Then("^Close the Browser$")
	public void close_the_Browser()
	{
	driver.close();
	}

	@Given("^Launch the New Tours$")
	public void launch_the_New_Tours()
	{
	WebDriverManager.firefoxdriver().setup();
	driver = new FirefoxDriver();
	driver.get("http://demo.guru99.com/test/newtours/login.php");
	driver.manage().window().maximize();
	obj =new Element();
	}

	@When("^Enter user name as \"([^\"]*)\" and Password as \"([^\"]*)\"$")
	public void enter_user_name_as_and_Password_as(String arg1, String arg2)
	{
	driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(arg1);
	driver.findElement(By.xpath("//input[@name='password']")).sendKeys(arg2);
	}

	@When("^Click on Login$")
	public void click_on_Login()
	{
		//Implemented POM: Calling the Element Class using an object and passing the webElement as an Argument
		WebElement a = driver.findElement(By.xpath("//input[@name='submit']"));
		obj.Click(a);	
	}

	@Then("^Successful Login$")
	public void successful_Login() throws AWTException, IOException
	{
		Assert.assertTrue(driver.findElement(By.xpath("//h3[contains(text(),'Login Successfully')]")).isEnabled());
		System.out.println("Test Case Pass");
		Robot robot = new Robot();
		java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle screenRectangle = new Rectangle(screenSize);
        BufferedImage image = robot.createScreenCapture(screenRectangle);
        File Des = new File(".//screenshot//LoginSuccesful.png");
        ImageIO.write(image, "png", Des);
		driver.quit();
	}

}
