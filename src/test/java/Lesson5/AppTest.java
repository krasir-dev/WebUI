package Lesson5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class AppTest extends AbstractTest {
    @Test
    void authTest() {

        Assertions.assertTrue(getDriver().findElement(By.xpath("//*[@id='userCabinetBtn']")).getText().contains("Lotud"));
        Assertions.assertEquals("Lotud", getDriver().findElement(By.xpath("//*[@id='userCabinetBtn']")).getText());
    }

    @Test
    void newOrder() {
        final String url = "https://spirk.ru/zakupka/yashkino-i-kdv---samaya-appetitnaya-zakupka-168221";
        getDriver().navigate().to(url);

        getDriver().findElement(By.xpath("//input[@data-product_id='613139040']")).click();
        Assertions.assertDoesNotThrow(() -> getDriver().findElement(By.xpath("//input[@class='btn btn-o order-button js-order__submit']")));

        getDriver().findElement(By.xpath("//input[@class='btn btn-o order-button js-order__submit']")).click();
        //Assertions.assertTrue(getDriver().findElement(By.xpath("//div[@class='order-added__title']")).getText().contains("успешно оформлен"));
        Assertions.assertTrue(getDriver().findElement(By.xpath("//div[@class='order-added__title']")).getText().contains("добавлен"));

        getDriver().findElement(By.xpath("//button[@id='closeBtn']")).click();
        Assertions.assertEquals(url, getDriver().getCurrentUrl());

    }

    @Test
    void editOrder() {
        final String url = "https://spirk.ru/my/orders/view/4840544?back=%2fmy%2forders%23pos4840544";
        final int orderID = 14325104;

        getDriver().navigate().to(url);

        getDriver().findElement(By.xpath("//*[@data-order_item_id='" + orderID + "']")).click();
        Assertions.assertDoesNotThrow(() -> getDriver().findElement(By.xpath("//input[@class='btn btn-o order-button js-order__submit']")));
        Assertions.assertDoesNotThrow(() -> getDriver().findElement(By.xpath("//input[@name='productCount']")));

        getDriver().findElement(By.xpath("//input[@name='productCount']")).sendKeys(Keys.BACK_SPACE);
        getDriver().findElement(By.xpath("//input[@name='productCount']")).sendKeys("3");

        getDriver().findElement(By.xpath("//input[@class='btn btn-o order-button js-order__submit']")).click();

        getDriver().navigate().to(url);
        Assertions.assertTrue(getDriver().findElement(By.xpath("//tr[@id='oi" + orderID + "']/td[6]")).getText().contains("3"));


    }

    @Test
    void changeOffice() {
        final String url = "https://spirk.ru/my/orders/view/4840544?back=%2fmy%2forders%23pos4840544";

        getDriver().navigate().to(url);

        getDriver().findElement(By.xpath("//*[@class='jsSelectDelivery']")).click();
        Assertions.assertTrue(getDriver().findElement(By.xpath("//span[@class='ui-dialog-title']")).getText().contains("Выберите способ получения заказа"));

        getDriver().findElement(By.xpath("//input[@value='17449']")).click();
        getDriver().findElement(By.xpath("//button[@id='selectDeliveryMethodBtn']")).click();
        getDriver().navigate().to(url);
        Assertions.assertTrue(getDriver().findElement(By.xpath("//div[@class='my-order-delivery__title']")).getText().contains("Для сотрудников"));


    }

    @Test
    void addAndRemoveBookmark() {
        final String url = "https://spirk.ru/zakupka/yashkino-i-kdv---samaya-appetitnaya-zakupka-168221";
        getDriver().navigate().to(url);

        getDriver().findElement(By.xpath("//button[@id='bookmarkBtn']")).click();
        Assertions.assertDoesNotThrow(() -> getDriver().findElement(By.xpath("//button[@class='btn btn-o btn-bookmark btn-bookmark_in']")));

        getDriver().findElement(By.xpath("//button[@id='bookmarkBtn']")).click();
        Assertions.assertDoesNotThrow(() -> getDriver().findElement(By.xpath("//button[@class='btn btn-o btn-bookmark btn-bookmark_out']")));

    }

    @Test
    void logOut() {
        Actions search = new Actions(getDriver());
        search.click(getDriver().findElement(By.xpath("//*[@id='userCabinetBtn']")))
                .pause(1000L)
                .click(getDriver().findElement(By.xpath("//*[@class='dd-menu__Logout']")))
                .build()
                .perform();

        Assertions.assertDoesNotThrow(() -> getDriver().findElement(By.xpath("//div[@id='authInfo']")));
    }


}
