package com.cydeo.tests.day2_locator_getText_getAttribute.homeWorks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T4_PracticeCydeo_ClassLocatorPractice {

    public static void main(String[] args) {

        //TC #4: Practice Cydeo – Class locator practice
        //1- Open a Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //2- Go to: https://practice.cydeo.com/inputs
        driver.get("https://practice.cydeo.com/inputs");
        //3- Click to “Home” link
        WebElement homeElement = driver.findElement(By.className("nav-link"));
        homeElement.click();

        //4- Verify title is as expected:
        //Expected: Practice
        String expectedTitle = "Practice";
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title verification PASSED!");
        }else  {
            System.out.println("Title verification FAILED ! !");
        }
        //PS: Locate “Home” link using “className” locator
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.close();


    }


}
