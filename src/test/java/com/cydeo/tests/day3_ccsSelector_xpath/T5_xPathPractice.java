package com.cydeo.tests.day3_ccsSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T5_xPathPractice {

    public static void main(String[] args) {

        //TC #5: NextBaseCRM, locators, getText(), getAttribute() practice
        //1- Open a Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();


        //2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes");


        //3- Enter incorrect username into login box:

        WebElement loginInput = driver.findElement(By.xpath("//*[@id='login-popup']/form/div[2]/div[1]/input"));
        loginInput.sendKeys("asdklsadhadsa");



        //4- Click to `Reset password` button
                                             // driver.findElement(By.className("login-btn"));
        WebElement resetPassWordButton = driver.findElement(By.xpath("//button[@class='login-btn']"));
        resetPassWordButton.click();




        //5- Verify “error” label is as expected
        //Expected: Login or E-mail not found

        String expectedErrorLabelMassage= "Login or E-mail not found";
        WebElement actualErrorLabelElement = driver.findElement(By.xpath("//div[@class=\"errortext\"]"));

        String actualErrorLabelMassage = actualErrorLabelElement.getText();

        if (expectedErrorLabelMassage.equals(actualErrorLabelMassage)){
            System.out.println("Error label massage verification PASSED!");
        }else {
            System.out.println("Error label massage verification FAILED ! !");
        }




        driver.close();




        //PS: Inspect and decide which locator you should be using to locate web
        //elements.
        //PS2: Pay attention to where to get the text of this button from





    }



}
