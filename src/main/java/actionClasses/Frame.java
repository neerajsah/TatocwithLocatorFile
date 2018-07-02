package actionClasses;


import java.io.IOException;
import util.FindElement;
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
public class Frame {
    
    WebDriver driver;
    
    public Frame(WebDriver driver)
    {
      this.driver=driver;
    }
    
    public void frameDungeon() throws IOException
    {  
        AssertCheck ac=new AssertCheck(driver);
        FindElement find=new FindElement(driver);
        
       driver.switchTo().frame("main");
       
       String box1= find.findElement("First_box_color").getAttribute("class");
//       String box1= driver.findElement(By.id("answer")).getAttribute("class");

       driver.switchTo().frame("child");
       
       String box2= find.findElement("Second_box_color").getAttribute("class");
//       String box2= driver.findElement(By.id("answer")).getAttribute("class");

       while(!box1.equals(box2))
        {
        driver.switchTo().defaultContent();
        driver.switchTo().frame("main");
        
        find.findElement("Repaint_button").click();
//        driver.findElement(By.linkText("Repaint Box 2")).click();

        driver.switchTo().frame("child");
        
        box2= find.findElement("Second_box_color").getAttribute("class");
//        box2= driver.findElement(By.id("answer")).getAttribute("class");
        }
        driver.switchTo().defaultContent();
        driver.switchTo().frame("main");
        
        find.findElement("Proceed_button").click();
//        driver.findElement(By.linkText("Proceed")).click();
        
        ac.assertCheck("http://10.0.1.86/tatoc/basic/drag", "Assert Failed");
       //Assert.assertEquals("http://10.0.1.86/tatoc/basic/drag",driver.getCurrentUrl(),"Assert Failed");
    }
}
