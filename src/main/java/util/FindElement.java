/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import actionClasses.LocatorsMap;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author neerajsah
 */
public class FindElement {
    
    LocatorsMap locator;
    WebDriver driver;
    
    public FindElement(WebDriver driver) throws IOException
    {
      locator=new LocatorsMap();
      this.driver=driver;
    }
    
    public WebElement findElement(String locatorName)
    {
         String typeOfElement = locator.getLocatorType(locatorName);
	String valueOfElement = locator.getLocatorValue(locatorName);
    
        if(typeOfElement.equals("id") == true)
        {
	  return driver.findElement(By.id(valueOfElement)); 
	}	  
	else if(typeOfElement.equals("linkText") == true) 
        {
	  return driver.findElement(By.linkText(valueOfElement));
	}
	else if(typeOfElement.equals("className") == true) 
        {
	  return driver.findElement(By.className(valueOfElement));
        }
	else if(typeOfElement.equals("partialLinkText") == true) 
        {
	  return driver.findElement(By.partialLinkText(valueOfElement));
	}
	else if(typeOfElement.equals("cssSelector") == true) 
        {
	  return driver.findElement(By.cssSelector(valueOfElement));
	}
	else {
		return driver.findElement(By.xpath(valueOfElement));
	     }
    }
    
}
