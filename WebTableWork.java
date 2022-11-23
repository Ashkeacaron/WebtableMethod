package com.WebTableTask;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableWork {
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver drive=new ChromeDriver();
		drive.get("https://www.redbus.in/");
		drive.manage().window().maximize();
		
		WebElement from = drive.findElement(By.id("src"));
		from.sendKeys("Chennai");
		Thread.sleep(2000);
		
		WebElement To = drive.findElement(By.id("dest"));
		To.sendKeys("Madurai");
		Thread.sleep(2000);
		
		drive.findElement(By.id("onward_cal")).click();  //to click the table
		Thread.sleep(2000);
		WebElement table = drive.findElement(By.tagName("table")); 		//when use web table concept use tagname for the locator.
           //to do locate the  table
		List<WebElement> rows = table.findElements(By.tagName("tr")); //to do locate the table row
		for (int i = 0; i <rows.size() ; i++) {   //the inheriate to the table rows
			WebElement row=rows.get(i);
			List<WebElement> datas = row.findElements(By.tagName("td"));
			for (int j =0 ; j <datas.size() ; j++) { //to inheriate the table row and  choose the date 
				WebElement data=datas.get(j);
				String text = data.getText();
				if (text.equals("28")) {
				data.click();
				}
			}
			
		}
		WebElement search = drive.findElement(By.id("search_btn"));
		search.click();
		Thread.sleep(2000);
		
		TakesScreenshot ts=(TakesScreenshot)drive; 
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File("C:\\Users\\User\\eclipse-workspace\\WebTableConcept\\Screenshot\\red.png");
		FileUtils.copyFile(source, target);
	
				
				
					
	}			
	}	                              	
	
		
		
		

