package com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

//import com.sun.xml.bind.v2.schemagen.xmlschema.List;

public class Functions  { //This class contains all the functions required for automation

	public static String navigate_to(WebDriver driver, String url) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().window().maximize();
		return null;
	}


	public static String click_element(WebDriver driver, String strLocType, String strLocalValue) throws InterruptedException { // ised to click an element
		switch(strLocType)
		{		
		case "id" :
			driver.findElement(By.id(strLocalValue)).click();
			break;
		case "xpath" :
			driver.findElement(By.xpath(strLocalValue)).click();
			break;
		case "linkText" :
			driver.findElement(By.linkText(strLocalValue)).click();
			break;
		}
		Thread.sleep(5000);
		return null;
}
	
	public static String sendKeys(WebDriver driver, String strLocType, String strLocalValue, String param1) throws InterruptedException { //used to enter the text in a text box
		switch(strLocType)
		{
		case "id" :
			driver.findElement(By.id(strLocalValue)).sendKeys(param1);
			break;
		case "xpath" :
			driver.findElement(By.xpath(strLocalValue)).sendKeys(param1);
			break;
		case "linkText" :
			driver.findElement(By.linkText(strLocalValue)).sendKeys(param1);
			break;
		}
		Thread.sleep(5000);
		return null;
}
	public static void quit_driver(WebDriver driver) { //Used to  quit the entire browser session with all its tabs and windows
		driver.quit();
	}
	
	public static void wait(WebDriver driver) throws InterruptedException { //Used to pause the execution of the current thread
		Thread.sleep(5000);
	}
	
	public static String verifyText(WebDriver driver, String param1) { // It verifies whether given text is present or not
		
		if (driver.getPageSource().contains(param1)) {
			System.out.println(param1+ " text is present in home page");
		}
		else {
			System.out.println(param1+ " text is not present in home page");
		}
		return null;
	}
	
	public static String getOptions(WebDriver driver, String strLocalValue) { //Used to get the all the options from dropsown
		
		java.util.List<WebElement> op = driver.findElements(By.xpath(strLocalValue));
		int size = op.size();
		
		for(int i=0; i<size; i++) {
			String options = op.get(i).getText();
			System.out.println("Options from the dropdown are: "+options);
			
			
		}
		
		
		return null;
	}
	
	public static String getVerifyOptions(WebDriver driver, String strLocalValue, String param1 ) { //Used to verify the given option present in the dropdown or not
		
		System.out.println("Entered into get verify options");
		java.util.List<WebElement> op = driver.findElements(By.xpath(strLocalValue));
		int size = op.size();
		
		for(int i=0; i<size; i++) {
			String options = op.get(i).getText();
			System.out.println("Options from the dropdown are: "+options);
			System.out.println("Param is : "+param1);
			if(options.contains(param1)) {
				System.out.println(param1+ " is present in dropdownlist");
			}
			else
			{
				System.out.println(param1+ " is not present in dropdownlist");
			}
		}
		
		
		return null;
	}
	
	public static String clearText(WebDriver driver, String strLocType, String strLocalValue) throws InterruptedException { // Used to clear the entered text
		
		switch(strLocType)
		{		
		case "id" :
			driver.findElement(By.id(strLocalValue)).clear();;
			break;
		case "xpath" :
			driver.findElement(By.xpath(strLocalValue)).clear();
			break;
		case "linkText" :
			driver.findElement(By.linkText(strLocalValue)).clear();
			break;
		}
		Thread.sleep(5000);
		return null;
	}
	
	public static String webTableRowCount(WebDriver driver, String strLocalValue, String param1) {//Gives the row count of a table
		System.out.println("Entered into web table row count");
		List<WebElement> r = driver.findElements(By.xpath(strLocalValue));
	int a = r.size();
	System.out.println("No of rows : "+a);
	String s=Integer.toString(a);
	if(s.equals(param1)) {
		System.out.println(param1+" rows are present in table");
	}
	else
	{
		System.out.println(param1+" rows are not present in table");
	}
	return null;
		
	}

public static String dragAndDrop (WebDriver driver, String srcLocalValue, String destLoacalValue) { //Used to drag and drop the element from source to required destination
	WebElement from = driver.findElement(By.xpath(srcLocalValue));
	System.out.println("from is: "+from);
	WebElement to = driver.findElement(By.xpath(destLoacalValue));
	System.out.println("to is: "+to);
	
	
	int x = to.getLocation().x;
    int y = to.getLocation().y;
System.out.println("x is: "+x);
System.out.println("y is:"+y);
    Actions actions = new Actions(driver);
    actions.moveToElement(from)
            .pause(Duration.ofSeconds(1))
            .clickAndHold(from)
            .pause(Duration.ofSeconds(1))
            .moveByOffset(x, y)
            .moveToElement(to)
            .moveByOffset(x,y)
            .pause(Duration.ofSeconds(1))
            .release().build().perform();
	
	
	
	
		/*
		 * action.clickAndHold(from) .pause(Duration.ofSeconds(2)) .moveToElement(to)
		 * .pause(Duration.ofSeconds(2)) .release() .build() .perform();
		 */
	System.out.println("Element dropped into destination location");
	
	return null;
}
	
	
	
	
}