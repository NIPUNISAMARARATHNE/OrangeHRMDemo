package OrangeHRM;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AssertOrg {
    WebDriver driver;

    @Test
    public void urlVerification() throws InterruptedException {
        Thread.sleep(8000);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(8000);

        //Text assertion
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        Assert.assertEquals(actualURL, expectedURL, "URL is mismatched");
        System.out.println("URL is matched");

    }

    @Test
    public void loginToSystem1() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[2]/div[1]/div[2]/input[1]")).sendKeys("admin1234");
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[3]/button[1]")).click();

        Thread.sleep(3000);

        boolean elementPresent = isElementPresent(driver, By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/p[1]"));

        if (!elementPresent) {
            Assert.fail("Error Alert is not displayed");
        } else {
            WebElement errorAlertElement = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/p[1]"));
            String actualValue = errorAlertElement.getText();
            String expectedValue = "Invalid credentials";
            Assert.assertEquals(actualValue, expectedValue, "Expected value is not displayed");
            System.out.println(actualValue);
        }

    }


    private static boolean isElementPresent(WebDriver driver, By locator) {
        try {
            driver.findElement(locator);
            return true; // Element found
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false; // Element not found
        }
    }

}







