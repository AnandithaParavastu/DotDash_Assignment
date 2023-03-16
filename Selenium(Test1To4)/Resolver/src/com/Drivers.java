package com;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Drivers extends Functions {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\Automation\\driver\\chromedriver_win32\\chromedriver.exe" ); //This chromedriver path is from my system
		WebDriver driver = new ChromeDriver();
		
		String path =
				  "D:/AutomationChallengeIDC/Resolver.xlsx";  //this excel path is from my system
				  File file = new File(path);
				  FileInputStream fis = new FileInputStream(file);
				  
				  XSSFWorkbook wb = new XSSFWorkbook(fis);
				  String page = "Test1";
				  XSSFSheet sheet1 = wb.getSheet(page); 
			  int rowNum=sheet1.getLastRowNum()+1;
				  System.out.println("row count : "+rowNum);
				  int colNum = sheet1.getRow(0).getLastCellNum();
				  System.out.println("col count  : "+colNum);
				  String[][] data = new String[rowNum][colNum]; 
				  
				  for(int i=0; i<=rowNum-1; i++) {
						XSSFRow row = sheet1.getRow(i); 
						
						for(int j=0; j<=colNum-1; j++) {
							   XSSFCell cell = row.getCell(j);
							//  System.out.println("cell is: "+cell);
							String value = cell.toString();
							   data[i][j] = value;
							 // System.out.println("data is :"+data[i][j]);
						}
						
	}
				 
					
					for (int i=2; i<=rowNum-1; i++) {  // It iterates and pick the required function that is mentioned in excel sheet
						switch (data[i][3]) { 
						case "navigate_to" : 
							navigate_to(driver, data[i][6]);
							System.out.println("Navigated");
							break;
						case "sendKeys" : 
							sendKeys(driver, data[i][4], data[i][5], data[i][6]);
							System.out.println("Entered");
							break;
						case "click_element" :
						click_element(driver, data[i][4],data[i][5]);
						System.out.println("clicked");
						break;
						case "quit_driver" :
							quit_driver(driver);
							System.out.println("Quit");
							break;
						case "wait" :
							wait(driver);
							System.out.println("wait");
							break;
						case "verifyText" :
							verifyText(driver, data[i][6]);
							System.out.println("find text");
							break;
						case "getVerifyOptions" :
							getVerifyOptions(driver, data[i][5], data[i][6]);
							System.out.println("getVerifyOptions");
							break;
						case "getOptions" :
							getOptions(driver, data[i][5]);
							System.out.println("getOptions");
							break;
						case "clearText" :
							clearText(driver, data[i][4], data[i][5]);
							System.out.println("clear text");
							break;
						case "webTableRowCount" :
							webTableRowCount(driver, data[i][5], data[i][6]);
							System.out.println("webTableRowCount");
							break;
						case "dragAndDrop" :
							dragAndDrop(driver, data[i][5], data[i][7]);
							System.out.println("dragAndDrop");
							break;
						default :
							break;
						}
						
					}
					 
					
					

				}



}
