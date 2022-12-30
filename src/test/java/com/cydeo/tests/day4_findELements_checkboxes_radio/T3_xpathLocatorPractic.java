package com.cydeo.tests.day4_findELements_checkboxes_radio;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T3_xpathLocatorPractic {


    public static void main(String[] args) {


        //TC #6: XPATH LOCATOR practice
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        //2. Go to http://practice.cydeo.com/multiple_buttons
        driver.get("http://practice.cydeo.com/multiple_buttons");

        //3. Click on Button 1
        WebElement button1 = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        button1.click();

        //4. Verify text displayed is as expected:
        //Expected: “Clicked on button one!”
        WebElement clickedOnButtonText = driver.findElement(By.xpath("//p[@id='result']"));
        String actualClickedOnButtonTextMassage =  clickedOnButtonText.getText();
        String expectedClickedOnButtonTextMassage = "Clicked on button one!";

        if (expectedClickedOnButtonTextMassage.equals(actualClickedOnButtonTextMassage)){
            System.out.println("button 1 text verification PASSED !");
        }else {
                System.out.println("button 1 text verification FAİLED ! !");
        }

        driver.close();

    }

}
