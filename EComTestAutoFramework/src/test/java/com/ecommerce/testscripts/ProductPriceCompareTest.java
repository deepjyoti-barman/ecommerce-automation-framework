package com.ecommerce.testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.ecommerce.base.BaseTest;
import com.ecommerce.pages.AmazonProductListPage;
import com.ecommerce.pages.FlipkartHomePage;
import com.ecommerce.pages.FlipkartProductListPage;

/**
 * Test class which will contain test methods to compare the prices of different products.
 * 
 * @author Deepjyoti Barman
 * @since January 31, 2020
 */
public class ProductPriceCompareTest extends BaseTest
{
    /* Test to check and compare the prices of "IPhone XR (64 GB) Yellow" in Amazon and Flipkart */
    @Test
    public void tc_001_iphonePriceCompare() throws IOException
    {
		String productName = "iPhone XR (64GB) - Yellow";
		
		AmazonProductListPage amazonPLP = amazonHP.search(productName);
		int iphonePriceAmazon = amazonPLP.getiphoneModelPrice();
		
		FlipkartHomePage flipkartHP = navigateToFlipkart();
		FlipkartProductListPage flipkartPLP = flipkartHP.search(productName);
		int iphonePriceFlipkart = flipkartPLP.getiphoneModelPrice();
			
		System.out.println("Price of '" + productName + "' on Amazon ==> " + iphonePriceAmazon);
		System.out.println("Price of '" + productName + "' on Flipkart ==> " + iphonePriceFlipkart);
			
		if (iphonePriceAmazon == iphonePriceFlipkart)
			System.out.println("\n[RESULT]: price of the product '" + productName + "' on FLIPKART is equal to the price of the product in AMAZON");
		else if (iphonePriceAmazon > iphonePriceFlipkart)
			System.out.println("\n[RESULT]: price of the product '" + productName + "' on FLIPKART is lesser than price of the product in AMAZON");
		else
			System.out.println("\n[RESULT]: price of the product '" + productName + "' on AMAZON is lesser than price of the product in FLIPKART");
    }
}
