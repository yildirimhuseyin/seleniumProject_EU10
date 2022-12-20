package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigations {


    public static void main(String[] args) throws InterruptedException {

        // 1- set up the browser
        WebDriverManager.chromedriver().setup();

        // 2- Set up Create instance of the driver
        WebDriver driver = new ChromeDriver();

        // 3- Go to the "https://www.tesla.com"
        driver.get("https://www.tesla.com");

        //driver.getTitle(): get the title of the page
        String currentTitle = driver.getTitle();

        // get the current URL using selenium:
        String currentUrl = driver.getCurrentUrl();



        // stop code execution for 3 second
        Thread.sleep(3000);

        // use selenium to navigate back
        driver.navigate().back();

        // stop code execution for 3 second
        Thread.sleep(3000);

        // use selenium to navigate forward
        driver.navigate().forward();

        // stop code execution for 3 second
        Thread.sleep(3000);

        // use selenium to navigate refresh
         driver.navigate().refresh();

        // stop code execution for 3 second
        Thread.sleep(3000);

        // use navigate().to():
        driver.navigate().to("https://www.google.com");


        // get the current title after getting on google page
        //System.out.println("driver.getTitle() = " + driver.getTitle());
        currentTitle = driver.getTitle();

        System.out.println("currentTitle = " + currentTitle);

        // get the current URL using selenium:
        currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);



    }



}
