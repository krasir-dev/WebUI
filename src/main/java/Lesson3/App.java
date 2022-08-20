package Lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        //Test1 (Auth)
        driver.get("https://spirk.ru/login?back=%2f");


        WebElement webElement1 = driver.findElement(By.xpath("//input[@id='Login']"));
        webElement1.sendKeys("9tq282qftdgi@mail.ru");
        WebElement webElement2 = driver.findElement(By.xpath("//input[@id='Password']"));
        webElement2.sendKeys("NT8rmFq962e68n");
        WebElement webElement3 = driver.findElement(By.xpath("//input[@type='submit']"));
        webElement3.click();

        //Test2 (New order)
        driver.navigate().to("https://spirk.ru/zakupka/yashkino-i-kdv---samaya-appetitnaya-zakupka-168221");
        WebElement webElement4 = driver.findElement(By.xpath("//input[@data-product_id='613139040']"));
        webElement4.click();
        WebElement webElement5 = driver.findElement(By.xpath("//input[@class='btn btn-o order-button js-order__submit']"));
        webElement5.click();
        WebElement webElement6 = driver.findElement(By.xpath("//button[@id='closeBtn']"));
        webElement6.click();

        //Test3 (Edit order)
        driver.navigate().to("https://spirk.ru/my/orders/view/4813198?back=%2fmy%2forders%23pos4813198");
        WebElement webElement7 = driver.findElement(By.xpath("//*[@data-order_item_id='14269489']"));
        webElement7.click();
        WebElement webElement8 = driver.findElement(By.xpath("//input[@name='productCount']"));
        webElement8.sendKeys(Keys.BACK_SPACE);
        webElement8.sendKeys("5");
        WebElement webElement9 = driver.findElement(By.xpath("//input[@class='btn btn-o order-button js-order__submit']"));
        webElement9.click();

        //Test4 (Change office)
        driver.navigate().to("https://spirk.ru/my/orders/view/4813198?back=%2fmy%2forders%23pos4813198");
        WebElement webElement10 = driver.findElement(By.xpath("//*[@class='jsSelectDelivery']"));
        webElement10.click();
        WebElement webElement11 = driver.findElement(By.xpath("//input[@value='17449']"));
        webElement11.click();
        WebElement webElement12 = driver.findElement(By.xpath("//button[@id='selectDeliveryMethodBtn']"));
        webElement12.click();

        driver.quit();

    }
}
