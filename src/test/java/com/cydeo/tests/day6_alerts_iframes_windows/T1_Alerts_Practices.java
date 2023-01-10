package com.cydeo.tests.day6_alerts_iframes_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_Alerts_Practices {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        //TC #1: Information alert practice
        //1. Open browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);



    }
    @AfterMethod
    public void tearDownMethod() throws InterruptedException {

        Thread.sleep(2000);
        driver.close();

    }

    @Test
    public void alert_test1() throws InterruptedException {

        //2. Go to website: http://practice.cydeo.com/javascript_alerts
        driver.get("http://practice.cydeo.com/javascript_alerts");


        //3. Click to “Click for JS Alert” button
        WebElement informationAlertButton = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        informationAlertButton.click();

        Thread.sleep(1000);


        // To be able to click to Alert OK button we need to switch driver's focus to Alert itself
        Alert alert = driver.switchTo().alert();

        //4. Click to OK button from the alert
        alert.accept();
        //5. Verify “You successfully clicked an alert” text is displayed.
        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));

        String expectedResultText = "You successfully clicked an alert";
        String actualResultText = resultText.getText();

        Assert.assertTrue(resultText.isDisplayed(),"Result text is NOT displayed."); //we can use either of those alert
        Assert.assertEquals(expectedResultText,actualResultText,"Actual result text is not as expected");






    }


    @Test
    public void confirmationAlertTest() throws InterruptedException {


        //2. Go to website: http://practice.cydeo.com/javascript_alerts
        driver.get("http://practice.cydeo.com/javascript_alerts");


        //3. Click to “Click for JS Confirm” button
        WebElement JSConfirmButton = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        Thread.sleep(2000);
        JSConfirmButton.click();


        //4. Click to OK button from the alert
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        alert.accept();

        //5. Verify “You clicked: Ok” text is displayed.
        String expectedResultText = "You clicked: Ok";
        String actualResultText = driver.findElement(By.xpath("//p[@id='result']")).getText();

        Assert.assertEquals(expectedResultText,actualResultText);


    }

    @Test
    public void informationAlertPractice() throws InterruptedException {

        //2. Go to website: http://practice.cydeo.com/javascript_alerts
        driver.get("http://practice.cydeo.com/javascript_alerts");

        //3. Click to “Click for JS Prompt” button
        WebElement JSPromptButton = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        Thread.sleep(2000);
        JSPromptButton.click();

        //4. Send “hello” text to alert
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("hello");

        //5. Click to OK button from the alert
        alert.accept();


        //6. Verify “You entered: hello” text is displayed.
        String expectedResultText = "You entered: hello";
        String actualResultText = driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertEquals(expectedResultText,actualResultText);


    }


}
