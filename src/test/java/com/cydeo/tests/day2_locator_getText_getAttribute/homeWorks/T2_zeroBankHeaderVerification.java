package com.cydeo.tests.day2_locator_getText_getAttribute.homeWorks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2_zeroBankHeaderVerification {


    public static void main(String[] args) {

        //TC #2: Zero Bank header verification
        //1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //2. Go to http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html");

        //3. Verify header text
        //Expected: “Log in to ZeroBank”
       String actualHeaderText = driver.findElement(By.className("page-header")).getText();
       String expectedHeaderText = "Log in to ZeroBank";

       if (expectedHeaderText.equals(actualHeaderText)){
           System.out.println("Header text verification PASSED !");
       }else {
           System.out.println("Header text verification FAILED ! !");
       }

        driver.close();

    }

}
