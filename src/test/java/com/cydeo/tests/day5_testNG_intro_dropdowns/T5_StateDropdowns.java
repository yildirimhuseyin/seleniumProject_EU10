package com.cydeo.tests.day5_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T5_StateDropdowns {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){

        //TC #5: Selecting state from State dropdown and verifying result
        //1. Open Chrome browser
    driver = WebDriverFactory.getDriver("Chrome");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }



    @Test
    public void stateDropdownsTest(){


        //2. Go to http://practice.cybertekschool.com/dropdown
        driver.get("http://practice.cybertekschool.com/dropdown");


        //3. Select Illinois
        Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        stateDropdown.selectByVisibleText("Illinois");

        //4. Select Virginia
        stateDropdown.selectByValue("VA");

        //5. Select California,
        stateDropdown.selectByIndex(5);

        //6. Verify final selected option is California.

        String expectedFinalSelectedOptionText = "California";
        String actualFinalSelectedOptionText =stateDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualFinalSelectedOptionText,expectedFinalSelectedOptionText);

        //Use all Select options. (visible text, value, index)


    }



}
