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

    public WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){

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


        //2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");


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


    @Test
    public void dateDropdownTest(){


        //2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");

        //3. Select “December 1st, 1923” and verify it is selected.
        //Select year using : visible text
         Select yearDropdown = new Select(driver.findElement(By.xpath("//select[@id='year']")));
         yearDropdown.selectByVisibleText("1924");

        //Select month using : value attribute
        Select monthDropdown = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        monthDropdown.selectByValue("11");

        //Select day using : index number
        Select dayDropdown = new Select(driver.findElement(By.xpath("//select[@id='day']")));
        dayDropdown.selectByIndex(0);

        // creating expected values
        String expectedYear = "1924";
        String expectedMonth = "December";
        String expectedDay = "1";


        // getting excepted values

        String actualYear = yearDropdown.getFirstSelectedOption().getText();
        String actualMonth = monthDropdown.getFirstSelectedOption().getText();
        String actualDay = dayDropdown.getFirstSelectedOption().getText();

        // create assertions
        Assert.assertEquals(expectedYear,actualYear);
        Assert.assertEquals(expectedMonth,actualMonth);
        Assert.assertEquals(expectedDay,actualDay);






    }



}
