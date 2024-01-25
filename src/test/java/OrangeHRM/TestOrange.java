package OrangeHRM;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestOrange {
    WebDriver driver;


    @Test
    public void launchApp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        String expectedUrl=("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        String actualUrl = driver.getCurrentUrl();
        assertEquals(actualUrl,expectedUrl, "not equal");

    }

   @Test
    public void login() throws InterruptedException {
      Thread.sleep(5000);
      driver.findElement(By.name("username")).sendKeys("Admin");
      driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[2]/div[1]/div[2]/input[1]")).sendKeys("admin123");
      driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[3]/button[1]")).click();
    }
    @Test
  public void navigateToMyInfo() throws InterruptedException {
       Thread.sleep(4000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/aside[1]/nav[1]/div[2]/ul[1]/li[6]/a[1]")).click();
        //driver.findElement(By.xpath("//h6[normalize-space()='Personal Details']")).sendKeys("Personal Details");
    }

    @Test
   public void verifyMyInfo() throws InterruptedException {
        Thread.sleep(6000);
        WebElement element = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/h6[1]"));
        Thread.sleep(5000);
        System.out.println(element.isDisplayed());
        System.out.println(element.getText());
        Thread.sleep(4000);
        //driver.quit();
    }

   @Test
    public void verifyLogin() throws InterruptedException {
       Thread.sleep(8000);
       WebElement element1 =driver.findElement(By.name("firstName"));
       Thread.sleep(8000);
       System.out.println(element1.isDisplayed());
       System.out.println(element1.getText());
       Thread.sleep(4000);
   }

   @Test
    public void navigateAdminPanel() throws InterruptedException {
        //Thread.sleep(4000);
        driver.findElement(By.xpath("//span[normalize-space()='Admin']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/input[1]")).sendKeys("Lisa Andrews");
        driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();
        Thread.sleep(4000);
   }

   @Test
   public void addSystemUser() throws InterruptedException {
        driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")).click();
//        driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]")).click();
       Thread.sleep(4000);
       driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/i[1]")).click();
       Thread.sleep(4000);
       //driver.findElement(By.xpath("//div[contains(text(),'Admin')]")).click();
       driver.findElement(By.xpath("//div[@class='oxd-select-text-input']//div[@class='dropdown-option'][1]"));
//        Select select = new Select(dropdownElement);
//        select.selectByVisibleText("Admin");

        Thread.sleep(2000);
   }

//    @Test
//    public void pIMPanel() throws InterruptedException {
//        Thread.sleep(3000);
//        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/aside[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]")).click();
//        Thread.sleep(5000);
//        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/input")).sendKeys("0262");
//        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[2]/button[2]")).click();
//        Thread.sleep(4000);
//    }
}



