package actionClasses;


import java.io.IOException;
import util.FindElement;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author neerajsah
 */
public class Pop {
    
    WebDriver driver;
    
    public Pop(WebDriver driver)
    {
      this.driver=driver;
    }
   
    public void popWindow() throws IOException
    { 
        AssertCheck ac=new AssertCheck(driver);
        FindElement find=new FindElement(driver);
        
        find.findElement("Popup_windows_button").click();
//      driver.findElement(By.linkText("Launch Popup Window")).click();

      ArrayList<String> tabs = new ArrayList<> (driver.getWindowHandles());
      driver.switchTo().window(tabs.get(1));
      
      find.findElement("Input_field").sendKeys("Just_Testing");
//      driver.findElement(By.id("name")).sendKeys("Just_Testing");

      find.findElement("Submit_button").click();
//      driver.findElement(By.id("submit")).click();

      driver.switchTo().window(tabs.get(0));
      
      find.findElement("Proceed_button").click();
//      driver.findElement(By.linkText("Proceed")).click();
      
      ac.assertCheck("http://10.0.1.86/tatoc/basic/cookie", "Assert Failed");
     // Assert.assertEquals("http://10.0.1.86/tatoc/basic/cookie",driver.getCurrentUrl(),"Assert Failed");
    }
}
