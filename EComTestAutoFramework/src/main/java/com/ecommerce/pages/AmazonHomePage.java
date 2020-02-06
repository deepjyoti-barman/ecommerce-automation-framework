package com.ecommerce.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Object repository of Amazon Home Page.
 * 
 * @author Deepjyoti Barman
 * @since January 31, 2019
 */
public class AmazonHomePage
{
    /* Defining all WebElements of the page */
    @FindBy(id="twotabsearchtextbox")
    private WebElement searchTB;
	
    /* Defining other members of the class */
    private WebDriver driver;
	
	
    /* Initialize all the elements of the page */
    public AmazonHomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	
    /* Actions to be performed on the page */
    /**
     * Write the given name in search textbox and press 'Enter' key to search the desired product.
     * 
     * @param productName Name of the product you want to search
     * @return The reference of next page to be loaded
     */
    public AmazonProductListPage search(String productName)
    {
        searchTB.sendKeys(productName, Keys.ENTER);
        return new AmazonProductListPage(driver);
    }
}
