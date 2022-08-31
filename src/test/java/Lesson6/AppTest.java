package Lesson6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AppTest extends AbstractTest{
    final String urlOrderPage = "https://spirk.ru/my/orders/view/4840544?back=%2fmy%2forders%23pos4840544";
    final String urlPurchasePage = "https://spirk.ru/zakupka/yashkino-i-kdv---samaya-appetitnaya-zakupka-168221";

    @Test
    void newOrder(){
        getDriver().navigate().to(urlPurchasePage);

        PurchasePage purchasePage = new PurchasePage(getDriver());

        purchasePage.getProductID().click();
        Assertions.assertDoesNotThrow(() -> purchasePage.getSubmitBtn());

        purchasePage.getSubmitBtn().click();
        Assertions.assertTrue(purchasePage.getOrderAddedTitle().getText().contains("добавлен"));

        purchasePage.getCloseBtn().click();
        Assertions.assertEquals(urlPurchasePage, getDriver().getCurrentUrl());
    }

    @Test
    void editOrder() {

        final int quantity = 6;
        getDriver().navigate().to(urlOrderPage);

        OrderPage orderPage = new OrderPage(getDriver());
        orderPage.editOrder();
        Assertions.assertDoesNotThrow(() -> orderPage.getSubmitBtn());
        Assertions.assertDoesNotThrow(() -> orderPage.getProductCount());
        orderPage.setProductCount(quantity);
        orderPage.submit();
        getDriver().navigate().refresh();
        Assertions.assertTrue(orderPage.getTableCount().getText().contains(Integer.toString(quantity)));
    }

    @Test
    void changeOffice() {

        getDriver().navigate().to(urlOrderPage);

        OrderPage orderPage = new OrderPage(getDriver());
        orderPage.getOfficeChangeBtn().click();
        Assertions.assertTrue(orderPage.getTitleChangeOffice().getText().contains("Выберите способ получения заказа"));
        orderPage.getStuffOffice().click();
        orderPage.getSelectDeliveryMethodBtn().click();
        getDriver().navigate().refresh();
        Assertions.assertTrue(orderPage.getOrderDeliveryTitle().getText().contains("Для сотрудников"));
    }

    @Test
    void addAndRemoveBookmark() {

        getDriver().navigate().to(urlPurchasePage);

        PurchasePage purchasePage = new PurchasePage(getDriver());
        purchasePage.getBookmarkBtn().click();
        Assertions.assertDoesNotThrow(() -> purchasePage.getBookMarkTrue());

        purchasePage.getBookmarkBtn().click();
        Assertions.assertDoesNotThrow(() -> purchasePage.getBookMarkFalse());
    }



}
