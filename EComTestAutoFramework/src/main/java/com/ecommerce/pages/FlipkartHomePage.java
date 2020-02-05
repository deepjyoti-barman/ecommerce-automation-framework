package com.ecommerce.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Object repository of Flipkart Home Page
 * 
 * @author Deepjyoti Barman
 * @since January 31, 2019
 */
public class FlipkartHomePage
{
    /* Defining all WebElements of the page */
    @FindBy(name="q")
    private WebElement searchTB;
	
    @FindBy(css="._2AkmmA._29YdH8")
    private WebElement closeLoginPopup; 

    /* Defining other members of the class */
    private WebDriver driver;
	
	
    /* Initialize all the elements of the page */
    public FlipkartHomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	
    /* Actions to be performed on the page */
    /**
     * Close the login pop-up, write the given name in search textbox and press 'Enter' key to search the desired product 
     * 
     * @param productName Name of the product you want to search
     */
    public FlipkartProductListPage search(String productName)
    {
        closeLoginPopup.click();
        searchTB.sendKeys(productName, Keys.ENTER);
        return new FlipkartProductListPage(driver);
    }
}
