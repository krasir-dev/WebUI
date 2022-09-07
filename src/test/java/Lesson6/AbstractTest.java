package Lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public abstract class AbstractTest {
    private static WebDriver driver;

    @BeforeAll
    static void init(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--headless");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @BeforeEach
    void initMainPage() {
        Assertions.assertDoesNotThrow(() -> getDriver().navigate().to("https://spirk.ru"),
                "Страница не доступна");
        //Assertions.assertTrue(true);
    }

    @BeforeEach
    void login() {
        new LoginPage(getDriver()).loginIn("9tq282qftdgi@mail.ru", "NT8rmFq962e68n");
        Assertions.assertEquals("https://spirk.ru/?after=userLogin",getDriver().getCurrentUrl());
    }


    @AfterEach
    void close(){
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.logOut();
        Assertions.assertDoesNotThrow(() -> loginPage.getAuthInfo());

    }
    @AfterAll
    static void logOut() {
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
