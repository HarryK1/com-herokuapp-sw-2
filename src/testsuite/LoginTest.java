package testsuite;
/**
 * 3. Write down the following test into ‘LoginTest’ class 1. userSholdLoginSuccessfullyWithValidCredentials  * Enter “tomsmith” username
 * * Enter “SuperSecretPassword!” password
 * * Click on ‘LOGIN’ button
 * * Verify the text “Secure Area”
 * 2. verifyTheUsernameErrorMessage
 * * Enter “tomsmith1” username
 * * Enter “SuperSecretPassword!” password
 * * Click on ‘LOGIN’ button
 * * Verify the error message “Your username
 * is invalid!”
 * 3. verifyThePasswordErrorMessage
 * * Enter “tomsmith” username
 * * Enter “SuperSecretPassword” password
 * * Click on ‘LOGIN’ button
 * * Verify the error message “Your password
 * is invalid!”
 */

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //enter tomsmith username
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        //enter SuperSecretPassword! password
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        //click on login button
        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
        //verify the text Secure Area
        String expectedDisplay = "Secure Area";
        String actualDisplay = driver.findElement(By.tagName("h2")).getText();
        Assert.assertEquals("Secure Area",expectedDisplay, actualDisplay);
    }

    @Test
    public void verifyTheUsernameErrorMessage(){
        //enter tomsmith1 username
        driver.findElement(By.id("username")).sendKeys("tomsmith1");
        //enter SuperSecretPassword! password
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        //click on login button
        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
        //verify the error message Your username is invalid!
        String expectedDisplay = "Your username is invalid!\n"+"×";
        String actualDisplay = driver.findElement(By.id("flash")).getText();
        Assert.assertEquals("Your username is invalid!",expectedDisplay, actualDisplay);
    }

    @Test
    public void verifyThePasswordErrorMessage(){
        //enter tomsmith username
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        // enter SuperSecretPassword password
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword");
        //click on login button
        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
        //verify the error message Your password is invalid!
        String expectedDisplay = "Your password is invalid!\n"+"×";
        String actualDisplay = driver.findElement(By.id("flash")).getText();
        Assert.assertEquals("Your password is invalid!",expectedDisplay, actualDisplay);
    }

    @After
    public void tearDown(){
        closeBrowser();
    }


}
