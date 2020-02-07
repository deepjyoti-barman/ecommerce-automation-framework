package com.ecommerce.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.ecommerce.base.IAutoConstant;

/**
 * It is collection of commonly used methods throughout the framework.
 * 
 * @author Deepjyoti Barman
 * @since January 31, 2020
 */
public class CommonLib implements IAutoConstant
{
    /**
     * Sets the waiting time for loading a page, loading an element and loading a script.
     * 
     * @param driver Current driver reference in use 
     */
    public void setElementPageScriptLoadTimeout(WebDriver driver)
    {
        driver.manage().timeouts().implicitlyWait(IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
    }
	
	
    /**
     * Set the waiting time for loading a page, loading an element and loading a script taking parameters from user.
     * 
     * @param driver Current driver reference in use
     * @param iwTimeoutInSecs Implicit wait timeout in seconds
     * @param plTimeoutInSecs Page load timeout in seconds
     * @param sTimeoutInSecs Script timeout in seconds
     */
    public void setElementPageScriptLoadTimeout(WebDriver driver, long iwTimeoutInSecs, long plTimeoutInSecs, long sTimeoutInSecs)
    {
        driver.manage().timeouts().implicitlyWait(iwTimeoutInSecs, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(plTimeoutInSecs, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(sTimeoutInSecs, TimeUnit.SECONDS);
    }
}
