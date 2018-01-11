package day01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//6. Create a new test in a new Java class, specify test name in accordance with checking functionality
public class SeleniumTest {

    private WebDriver driver;

    @BeforeTest
    void init() {
        //1. Browser - Chrome
        driver = new ChromeDriver();
        //2. Window - maximized
        driver.manage().window().maximize();
    }

    //3. All code should be formatted by functional blocks separated by functionality and meaning
    @Test
    public void testFrameworkWithChrome() {

        //7. Open test site by URL
        driver.navigate().to("https://jdi-framework.github.io/tests");

        //8. Assert Browser title
        Assert.assertEquals(driver.getTitle(), "Index Page");

        //9. Perform login
        WebElement elementToggle = driver.findElement(By.className("uui-profile-menu"));
        elementToggle.click();
        WebElement elementLogin = driver.findElement(By.id("Login"));
        elementLogin.sendKeys("epam");
        WebElement elementPassword = driver.findElement(By.id("Password"));
        elementPassword.sendKeys("1234");
        WebElement elementSubmit = driver.findElement(By.className("btn-login"));
        elementSubmit.click();

        //10. Assert User name in the left-top side of screen that user is loggined
        WebElement elementPhoto = driver.findElement(By.className("profile-photo"));
        WebElement elementUserName = elementPhoto.findElement(By.tagName("span"));
        String userName = elementUserName.getText();
        Assert.assertEquals("PITER CHAILOVSKII", userName);

        //11. Assert Browser title
        Assert.assertEquals(driver.getTitle(), "Index Page");
    }

    @AfterTest
    void close() {
        //    driver.close();
    }
}

