package com.ecommerce.base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.ecommerce.pages.AmazonHomePage;
import com.ecommerce.pages.FlipkartHomePage;
import com.ecommerce.utils.CommonLib;
import com.ecommerce.utils.FileLib;

/**
 * Parent of every test class. It is used to configure, setup and terminate the execution of test methods. 
 * 
 * @author Deepjyoti Barman
 * @since January 31, 2020
 */
public class BaseTest implements IAutoConstant
{
    static
    {
        System.setProperty(CHROME_KEY, CHROME_VALUE);
        System.setProperty(GECKO_KEY, GECKO_VALUE);
    }
	
    public CommonLib lib = new CommonLib();
    public FileLib fLib  = new FileLib();
    public WebDriver driver;
    public AmazonHomePage amazonHP;
    
    
    /**
     * Opens up the desired browser window.
     * 
     * @throws IOException
     */
    @BeforeClass
    public void openBrowser() throws IOException
    {
        String browser = fLib.getDataFromProperties("browser");
        System.out.println("------------------- Launching the browser -------------------");
        
        if (browser.equalsIgnoreCase("chrome"))
            driver = new ChromeDriver();
        else if (browser.equalsIgnoreCase("firefox"))
            driver = new FirefoxDriver();
        else
            System.out.println("We do not support this browser");
    }
    
    
    /**
     * Loads the required application on the browser.
     * 
     * @throws IOException
     */
    @BeforeMethod
    public void loadApp() throws IOException
    {
        System.out.println("------------------- Loading the Application -------------------");
        lib.setElementPageScriptLoadTimeout(driver);
        driver.manage().window().maximize();
        
        amazonHP = navigateToAmazon();
    }
    
    
    /**
     * Closes the currently open browser window.
     */
    @AfterClass
    public void closeBrowser()
    {
        System.out.println("------------------- Closing the browser -------------------");
        driver.close();
    }
    
    
    /**
     * Navigates to Amazon (http://www.amazon.in).
     * @throws IOException
     */
    public AmazonHomePage navigateToAmazon() throws IOException
    {
        String url = fLib.getDataFromProperties("url-amazon");
        driver.get(url);
        
        return new AmazonHomePage(driver);
    }
    
    
    /**
     * Navigates to Flipkart (http://www.flipkart.com).
     * @throws IOException
     */
    public FlipkartHomePage navigateToFlipkart() throws IOException
    {
        String url = fLib.getDataFromProperties("url-flipkart");
        driver.get(url);
        
        return new FlipkartHomePage(driver);
    }
}