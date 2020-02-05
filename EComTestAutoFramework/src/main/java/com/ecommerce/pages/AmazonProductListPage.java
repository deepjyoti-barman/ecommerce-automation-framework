package com.ecommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Object repository of Amazon Product List Page
 * 
 * @author Deepjyoti Barman
 * @since January 31, 2019
 */
public class AmazonProductListPage
{
    /* Defining all WebElements of the page */
    @FindBy(xpath="//span[text()='Apple iPhone XR (64GB) - Yellow']")
    private WebElement iphoneModelName;
	
    @FindBy(xpath="//span[text()='Apple iPhone XR (64GB) - Yellow']//ancestor::div[@class='sg-col-inner'][2]/div[2]//span[@class='a-price-whole']")
    private WebElement iphoneModelPrice;
	
	
    /* Initialize all the elements of the page */
    public AmazonProductListPage(WebDriver driver)
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
        String price = iphoneModelPrice.getText().trim().replace(",", "");
        return Integer.parseInt(price);
    }
}
