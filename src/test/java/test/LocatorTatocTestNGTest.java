package test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import actionClasses.BasicCourse;
import actionClasses.CookieHandle;
import actionClasses.Drag;
import actionClasses.Frame;
import actionClasses.Grid;
import actionClasses.Pop;
import java.io.IOException;

/**
 *
 * @author neerajsah
 */
public class LocatorTatocTestNGTest 
{
     WebDriver driver;
   
    @BeforeClass
    public void launchBrowser() throws InterruptedException
    { 
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\neerajsah\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://10.0.1.86/tatoc");
        
        System.out.print(driver.getCurrentUrl());
        Thread.sleep(0500);
    }
    
     @Test
    public void callBasic() throws InterruptedException, IOException
    {
        BasicCourse basic=new BasicCourse(driver);
        basic.basicCourseSelection();
        System.out.print(driver.getCurrentUrl());
    }   
        
    @Test(dependsOnMethods={"callBasic"})
    public void callGrid()throws InterruptedException, IOException
    {
        
        Grid grid=new Grid(driver);
        grid.gridGate();
        System.out.print(driver.getCurrentUrl());
    }
    
    @Test(dependsOnMethods={"callGrid"})
    public void callFrame()    throws InterruptedException, IOException
    {        
        Frame frame=new Frame(driver);
        frame.frameDungeon();
        System.out.print(driver.getCurrentUrl());
    }

    @Test(dependsOnMethods={"callFrame"})
    public void callDrag()throws InterruptedException, IOException
    {        
        Drag drag=new Drag(driver);
        drag.dragAround();
        System.out.print(driver.getCurrentUrl());
    }  
    
    @Test(dependsOnMethods={"callDrag"})
    public void callPop()throws InterruptedException, IOException
    {        
        Pop pop=new Pop(driver);
        pop.popWindow();
        System.out.print(driver.getCurrentUrl());
    }

    @Test(dependsOnMethods={"callPop"})
    public void callCookie()throws InterruptedException, IOException
    {
        CookieHandle cookie=new CookieHandle(driver);
        cookie.cookieHandling();
        System.out.print(driver.getCurrentUrl());
    }
    
   
    
    @AfterClass
    public void closeBrowser()
    { driver.quit();
    }
    
}
