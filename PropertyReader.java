package utils;

import java.util.*;
import java.io.*;

public class PropertyReader {
    public static Properties prop = new Properties();

    public static void testDataReader() {
        FileInputStream ip = null;
        try
        {
            ip = new FileInputStream("src/test/resources/testData.properties");
        } catch (FileNotFoundException e)
        {
            System.out.println("File Not Found");
            e.printStackTrace();
        }
        try
        {
            prop.load(ip);
        } catch (IOException e)
        {
            System.out.println("Input Output exception");
            e.printStackTrace();
        }
    }
}

