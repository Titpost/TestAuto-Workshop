package day01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Titov on 10.01.2018
 */
public class SeleniumTest {

    @Test
    public void testFrameworkWithChrome() {

        //1 create new
        WebDriver driver = new ChromeDriver();
        driver.manage().window().fullscreen();

        //2 go to tested page
        driver.navigate().to("https://jdi-framework.github.io/tests");

        //3 check title
        Assert.assertEquals(driver.getTitle(), "Index Page");

        //4 drop down login-form
        WebElement elementToggle = driver.findElement(By.className("uui-profile-menu"));
        elementToggle.click();

        //5 find login/password form and authenticate
        WebElement elementLogin = driver.findElement(By.id("Login"));
        elementLogin.sendKeys("epam");
        WebElement elementPassword = driver.findElement(By.id("Password"));
        elementPassword.sendKeys("1234");

        WebElement elementSubmit = driver.findElement(By.className("btn-login"));
        elementSubmit.click();

    //    driver.close();
    }
}

