package com.ecommerce.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.ecommerce.base.IAutoConstant;

/**
 * It is built for reading data from files of different formats given below:<br>
 * - <strong>.properties</strong><br>
 * - <strong>xls / .xlsx</strong><br>
 * - <strong>.json</strong><br>
 * - <strong>.xml</strong><br>
 * 
 * @author Deepjyoti Barman
 * @since January 31, 2020
 */
public class FileLib implements IAutoConstant
{
    /**
     * Built to get the required key from the .properties file.
     * 
     * @param key Key to search in the file
     * @return The value assigned to the respective key
     * @throws IOException
     */
    public String getDataFromProperties(String key) throws IOException
    {
        FileInputStream fis = new FileInputStream(DEFAULT_PROPERTIES_PATH);
        Properties prop = new Properties();
        prop.load(fis);
            
        String data = prop.getProperty(key);
        fis.close();
        
        return data;
    }
	
	
    /**
     * Built to get the required key from the .properties file placed in specified location.
     * 
     * @param key Key to search in the file
     * @param filePath Path of the .properties file
     * @return The value assigned to the respective key
     * @throws IOException
     */
    public String getDataFromProperties(String key, String filePath) throws IOException
    {
        FileInputStream fis = new FileInputStream(filePath);
        Properties prop = new Properties();
        prop.load(fis);
            
        String data = prop.getProperty(key);
        fis.close();
        
        return data;
    }
}