package com.cydeo.tests.day2_locator_getText_getAttribute.homeWorks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T3_BackAndForthNavigator {

    public static void main(String[] args) {

        //TC #3: Back and forth navigation
        //1- Open a Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2- Go to: https://google.com
        driver.get("https://google.com");

        WebElement acceptPopUp = driver.findElement(By.id("L2AGLb"));
        acceptPopUp.click();
        //3- Click to Gmail from top right.
        WebElement gmailElement = driver.findElement(By.linkText("Gmail"));
        gmailElement.click();

        //4- Verify title contains:
        //Expected: Gmail
        String expectedTitleContain = "Gmail";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedTitleContain)){
            System.out.println("Title contain verification PASSED !");
        }else {
            System.out.println("Title contain verification FAILED ! !");
        }

        //5- Go back to Google by using the .back();
        driver.navigate().back();
        //6- Verify title equals:
        //Expected: Google
        String expectedTitle = "Google";
        actualTitle = driver.getTitle();

        if (expectedTitle.equals(actualTitle)){
            System.out.println("Title verification PASSED !");
        }else {
            System.out.println("Title verification FAILED ! !");
        }
    }

}
