package Lesson6;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderPage extends AbstractPage {

    @FindBy(xpath = "//*[@data-order_item_id='14368431']")
    private WebElement editOrderBtn;

    @FindBy(xpath = "//input[@class='btn btn-o order-button js-order__submit']")
    private WebElement submitBtn;

    @FindBy(xpath = "//input[@name='productCount']")
    private WebElement productCount;

    @FindBy(xpath = "//tr[@id='oi14368431']/td[6]")
    private WebElement tableCount;

    @FindBy(xpath = "//*[@class='jsSelectDelivery']")
    private WebElement officeChangeBtn;

    @FindBy(xpath = "//span[@class='ui-dialog-title']")
    private WebElement titleChangeOffice;

    @FindBy(xpath = "//input[@value='17449']")
    private WebElement stuffOffice;

    @FindBy(xpath = "//button[@id='selectDeliveryMethodBtn']")
    private WebElement selectDeliveryMethodBtn;

    @FindBy(xpath = "//div[@class='my-order-delivery__title']")
    private WebElement orderDeliveryTitle;



    public OrderPage(WebDriver driver) {
        super(driver);
    }

    public void editOrder () {
        this.editOrderBtn.click();
    }



    public void setProductCount(int quantity) {
        this.productCount.sendKeys(Keys.BACK_SPACE);
        this.productCount.sendKeys(Integer.toString(quantity));
    }

    public void  submit() {
        this.submitBtn.click();
    }

    public WebElement getEditOrderBtn() {
        return editOrderBtn;
    }

    public WebElement getSubmitBtn() {
        return submitBtn;
    }

    public WebElement getProductCount() {
        return productCount;
    }

    public WebElement getTableCount() {
        return tableCount;
    }

    public WebElement getOfficeChangeBtn() {
        return officeChangeBtn;
    }

    public WebElement getTitleChangeOffice() {
        return titleChangeOffice;
    }

    public WebElement getStuffOffice() {
        return stuffOffice;
    }

    public WebElement getSelectDeliveryMethodBtn() {
        return selectDeliveryMethodBtn;
    }

    public WebElement getOrderDeliveryTitle() {
        return orderDeliveryTitle;
    }
}
