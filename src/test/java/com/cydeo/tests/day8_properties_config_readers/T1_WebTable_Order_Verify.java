package com.cydeo.tests.day8_properties_config_readers;

import com.cydeo.utilities.WebDriverFactory;
import com.cydeo.utilities.WebTableUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_WebTable_Order_Verify {
    WebDriver driver;


    @BeforeMethod

    public void setupMethod(){
        //TC #1: Web table practice
        //1. Go to: https://practice.cydeo.com/web-tables
    driver = WebDriverFactory.getDriver("chrome");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    driver.get("https://practice.cydeo.com/web-tables");

    }

    @Test
    public void order_name_verify_test(){


        // locate the cell that has Bob Martin text in it
        WebElement bobMartinTd =
                driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tbody//td[.='Bob Martin']"));

        //2. Verify Bob’s name is listed as expected.
        //Expected: “Bob Martin”
        String expectedName = "Bob Martin";
        String actualName = bobMartinTd.getText();

        Assert.assertTrue(actualName.equals(expectedName));


        // Locate Bob Martin's order name
        //3. Verify Bob Martin’s order date is as expected
        //Expected: 12/31/2021

        WebElement dateCell =
                driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tbody//td[.='Bob Martin']//following-sibling::td[3]"));
        String dateExpected = "12/31/2021";
        String dateActual = dateCell.getText();

        Assert.assertEquals(dateActual,dateExpected);


    }


    @Test
    public void test2(){
        String customerOrderDate1 = WebTableUtils.returnOrderDate(driver,"Alexandra Gray");

        System.out.println(customerOrderDate1);


    }


    // using WebTableUtils.orderVerify(); method
    @Test
    public void test3(){

        WebTableUtils.orderVerify(driver,"Bart Fisher","01/16/2021");

    }



}
