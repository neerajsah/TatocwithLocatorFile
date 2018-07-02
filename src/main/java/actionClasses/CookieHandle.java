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
public class CookieHandle {
    
    WebDriver driver;
    
    public CookieHandle(WebDriver driver)
    {
     this.driver=driver;
    }
    public String cookieValueExtract(String token)
    {
       String cookieValue = token.substring(7,token.length());
        
        return cookieValue;
    }
    
    public String cookieNameExtract(String token)
    {
       String cookieName = token.substring(0,5);
       
       return cookieName;
    }
    
    public void cookieHandling() throws IOException
    {  
        AssertCheck ac=new AssertCheck(driver);
        FindElement find=new FindElement(driver);
        
        find.findElement("Generate_token_link").click();
       //driver.findElement(By.linkText("Generate Token")).click();
       
       String token = find.findElement("Token").getText();
//       String token = driver.findElement(By.id("token")).getText();
       
       String cookieName=cookieNameExtract(token);
       String cookieValue=cookieValueExtract(token);
       
       org.openqa.selenium.Cookie cookie= new org.openqa.selenium.Cookie(cookieName,cookieValue);
       driver.manage().addCookie(cookie);
       
       find.findElement("Proceed_button").click();
//       driver.findElement(By.linkText("Proceed")).click();
       
       ac.assertCheck("http://10.0.1.86/tatoc/end", "Assert Failed");
       //Assert.assertEquals("http://10.0.1.86/tatoc/end",driver.getCurrentUrl(),"Assert Failed");
    }
    
    
}
