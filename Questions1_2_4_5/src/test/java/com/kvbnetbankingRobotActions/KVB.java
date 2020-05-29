package com.kvbnetbankingRobotActions;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class KVB {
	static WebDriver driver;

	public static void main (String[] args)throws AWTException, IOException
	{
		
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://www.kvbin.com/B001/ENULogin.jsp");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'Use virtual keyboard')]")));
		driver.findElement(By.xpath("//input[@id='securitykeyboard']")).click();
		driver.findElement(By.xpath("//input[@name='fldPassword']")).click();
		Robot robot = new Robot();	
		WebElement letter_K=driver.findElement(By.xpath("//input[@id='elemA4']"));
		robot.delay(20000);
		Point location = letter_K.getLocation();
		int x= location.getX();
		int y= location.getY();
        robot.mouseMove(x, y);
        System.out.println(x + "   "+y);
        robot.delay(10000);
        	robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Color colour = robot.getPixelColor(x, y);
        System.out.println(colour);
        driver.findElement(By.xpath("//input[@id='securitykeyboard']")).click();
        robot.delay(10000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(10000);
        driver.findElement(By.xpath("//select[@name='fldlitever']")).click();
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.delay(10000);
        robot.keyPress(KeyEvent.VK_UP);
        robot.delay(10000);
        robot.keyPress(KeyEvent.VK_DOWN);
        driver.findElement(By.xpath("//input[@name='fldLoginUserId']")).click();
        robot.keyPress(KeyEvent.VK_TAB);
        java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle screenRectangle = new Rectangle(screenSize);
        BufferedImage image = robot.createScreenCapture(screenRectangle);
        File Des = new File(".//screenshot//KVB Netbanking Robot.png");
        ImageIO.write(image, "png", Des);
        driver.close();

	}

}
