package com.wordpress;

import java.util.Iterator;
import java.util.List;
import java.io.IOException;
import java.util.ArrayList;

//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Wordpresslinks {
static WebDriver driver;
List<String> text = new ArrayList<>();

public void pagelink(String a) throws IOException
{
		driver.get(a);
		driver.manage().window().maximize();
		List<WebElement> links = driver.findElements(By.tagName("a"));
		Iterator<WebElement> it = links.iterator();
		String url = "";

	    while(it.hasNext())
	    {
	    	try {
	    		
	        url = it.next().getAttribute("href");
	        String linktext = it.next().getText();
	        System.out.println(url);
	        text.add(linktext);
	   }
	    	catch(Exception e)
	    	{
	    	}
  	/*
	        //FileOutputStream out = new FileOutputStream(".//screenshot//OutputSheet.xlsx");
	        XSSFWorkbook workbook = new XSSFWorkbook("D:\\Maveric Systems\\Picnic Program\\Session 4_Selenium\\OutputSheet.xlsx");
	        XSSFSheet sheet = workbook.createSheet("TextLink");
	        int cellnum = 0;
	        int rownum = 0;
	        Iterator<String> tempIterator = text.iterator();
	        Row row = sheet.createRow(rownum);
	        while (tempIterator.hasNext()) {
	            String temp = (String) tempIterator.next();
	            Cell cell = row.createCell(cellnum++);
	            cell.setCellValue(temp);
	}
	        workbook.close();
	        */
	    }
		
}	

public void imgsource(String b)
{
		driver.get(b);
		driver.manage().window().maximize();
		List<WebElement> links = driver.findElements(By.tagName("img"));
		Iterator<WebElement> it = links.iterator();
		String src = "";
	    while(it.hasNext())
	    {
	    	try {
	    		
	        src = it.next().getAttribute("src");
	        System.out.println(src);
	   }
	    	catch(Exception e)
	    	{
	    	}
	}
		
}
	public static void main(String[] args) throws IOException 
	{
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		Wordpresslinks link =new Wordpresslinks();
		Wordpresslinks img =new Wordpresslinks();
		// Base URL
		link.pagelink("https://wordpress.com/?aff=58022&cid=8348279");
		img.imgsource("https://wordpress.com/?aff=58022&cid=8348279");
		//Product -> Blog
		System.out.println("Now go for Blog Page");
		link.pagelink("https://wordpress.com/create-blog/?aff=58022&cid=8348279");
		img.imgsource("https://wordpress.com/create-blog/?aff=58022&cid=8348279");
		//Product -> Website
		System.out.println("Now go for Website Page");
		link.pagelink("https://wordpress.com/create-website/?aff=58022&cid=8348279");
		img.imgsource("https://wordpress.com/create-website/?aff=58022&cid=8348279");
		// Product -> Domains
		System.out.println("Now go for Domain Page");
		link.pagelink("https://wordpress.com/domains/?aff=58022&cid=8348279");
		img.imgsource("https://wordpress.com/domains/?aff=58022&cid=8348279");
		// Product -> ecommerce
		System.out.println("Now go for Ecommerce Page");
		link.pagelink("https://wordpress.com/ecommerce/?aff=58022&cid=8348279");
		img.imgsource("https://wordpress.com/ecommerce/?aff=58022&cid=8348279");
		// Product -> Self Hosted
		System.out.println("Now go for Self Hosted Page");
		link.pagelink("https://wordpress.com/com-vs-org/?aff=58022&cid=8348279");
		img.imgsource("https://wordpress.com/com-vs-org/?aff=58022&cid=8348279");
		// Features -> Overview
		System.out.println("Now go for Features Overview");
		link.pagelink("https://wordpress.com/features/?aff=58022&cid=8348279");
		img.imgsource("https://wordpress.com/features/?aff=58022&cid=8348279");
		// Features -> Themes
		System.out.println("Now go for Features Themes");
		link.pagelink("https://wordpress.com/themes?aff=58022&cid=8348279");
		img.imgsource("https://wordpress.com/themes?aff=58022&cid=8348279");
		// Features -> install-plugins
		System.out.println("Now go for Features install-plugins");
		link.pagelink("https://wordpress.com/install-plugins/?aff=58022&cid=8348279");
		img.imgsource("https://wordpress.com/install-plugins/?aff=58022&cid=8348279");
		// Features -> google api
		System.out.println("Now go for Features google api");
		link.pagelink("https://wordpress.com/google/?aff=58022&cid=8348279");
		img.imgsource("https://wordpress.com/google/?aff=58022&cid=8348279");
		// Resource -> Support
		System.out.println("Now go for Features Support");
		link.pagelink("https://wordpress.com/google/?aff=58022&cid=8348279");
		img.imgsource("https://wordpress.com/google/?aff=58022&cid=8348279");
		// Resource -> News
		System.out.println("Now go for Features News");
		link.pagelink("https://wordpress.com/blog/?aff=58022&cid=8348279");
		img.imgsource("https://wordpress.com/blog/?aff=58022&cid=8348279");
		// Resource -> Experts
		System.out.println("Now go for Experts");
		link.pagelink("https://wordpress.com/go/?aff=58022&cid=8348279");
		img.imgsource("https://wordpress.com/go/?aff=58022&cid=8348279");

	} 
            
	}

