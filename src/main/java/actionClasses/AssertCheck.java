/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actionClasses;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 *
 * @author neerajsah
 */
public class AssertCheck {
    
    WebDriver driver;
    
    public AssertCheck(WebDriver driver)
    {
     this.driver=driver;
    }
    
    public void assertCheck(String url,String msg)
    {
       Assert.assertEquals(url,driver.getCurrentUrl(),msg);
    }
    
}
