package actionClasses;


import java.io.IOException;
import util.FindElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
public class Drag {
    WebDriver driver;
    
    public Drag(WebDriver driver)
    {
      this.driver=driver;
    }
    
    public void dragDrop(WebElement from,WebElement to)
    {
       Actions action = new Actions(driver);
       action.dragAndDrop(from, to).build().perform();
    }
    
    public void dragAround() throws IOException
    {  
        AssertCheck ac=new AssertCheck(driver);
        FindElement find=new FindElement(driver);
        
       WebElement from= find.findElement("Dragbox_element");
//       WebElement from=driver.findElement(By.id("dragbox"));

       WebElement to= find.findElement("Dropbox_element");
//       WebElement to=driver.findElement(By.id("dropbox"));
      
       dragDrop(from,to);
       
       find.findElement("Proceed_button").click();
//       driver.findElement(By.linkText("Proceed")).click();
       
       ac.assertCheck("http://10.0.1.86/tatoc/basic/windows", "Assert Failed");
       //Assert.assertEquals("http://10.0.1.86/tatoc/basic/windows",driver.getCurrentUrl(),"Assert Failed");
    }
    
}
