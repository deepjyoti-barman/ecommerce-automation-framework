package com.ecommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Object repository of Flipkart Product List Page
 * 
 * @author Deepjyoti Barman
 * @since January 31, 2019
 */
public class FlipkartProductListPage
{
    /* Defining all WebElements of the page */
    @FindBy(xpath="//div[text()='Apple iPhone XR (Yellow, 64 GB)']")
    private WebElement iphoneModelName;
	
    @FindBy(xpath="//div[text()='Apple iPhone XR (Yellow, 64 GB)']/ancestor::div[@class='_1-2Iqu row']/div[2]//div[@class='_1vC4OE _2rQ-NK']")
    private WebElement iphoneModelPrice;
	
	
    /* Initialize all the elements of the page */
    public FlipkartProductListPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }
	
	
    /* Actions to be performed on the page */
    /**
     * Retrieve the price of the product from the page and return it back as an integer
     * 
     * @return The price of the product as an integer
     */
    public int getiphoneModelPrice()
    {
        String price = iphoneModelPrice.getText().trim().replaceAll("[^0-9]", "");
        return Integer.parseInt(price);
    }
}
