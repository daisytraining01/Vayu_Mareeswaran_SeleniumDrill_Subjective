package com.brokenlinks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Brokenlink {

	static WebDriver driver;
	
	public static void main(String[] args) throws MalformedURLException, IOException {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://maveric-systems.com/");
		driver.manage().window().maximize();
		List<WebElement> links = driver.findElements(By.tagName("a"));
		Iterator<WebElement> it = links.iterator();
		String url = "";
		HttpURLConnection urlconnect = null;
		int respCode = 200;
        while(it.hasNext()){
             url = it.next().getAttribute("href");
            System.out.println(url);
            urlconnect = (HttpURLConnection)(new URL(url).openConnection());
            urlconnect.setRequestMethod("HEAD");
            urlconnect.connect();
            respCode = urlconnect.getResponseCode();
            
            if(respCode >= 400){
                System.out.println(url+" Responded with "+respCode+"Hence it is a broken link" );
            }
            else{
                System.out.println(url+" Responded with" +respCode+"Hence it is valid link");
            }
                
        } 
            
	}

}
