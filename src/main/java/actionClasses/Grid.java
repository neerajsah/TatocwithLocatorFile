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
public class Grid {
    
    WebDriver driver;
    
    public Grid(WebDriver driver)
    {
      this.driver=driver;
    }
    
    public void gridGate() throws IOException
    {   
        AssertCheck ac=new AssertCheck(driver);
        FindElement find=new FindElement(driver);
        
        find.findElement("Green_gridbox").click();
//        driver.findElement(By.className("greenbox")).click();

        ac.assertCheck("http://10.0.1.86/tatoc/basic/frame/dungeon", "Assert Failed");
//Assert.assertEquals("http://10.0.1.86/tatoc/basic/frame/dungeon",driver.getCurrentUrl(),"Assert Failed");
    }
}
