package Lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PurchasePage extends AbstractPage {

    @FindBy(xpath = "//input[@data-product_id='613139040']")
    private WebElement productID;

    @FindBy(xpath = "//input[@class='btn btn-o order-button js-order__submit']")
    private WebElement submitBtn;

    @FindBy(xpath = "//div[@class='order-added__title']")
    private WebElement orderAddedTitle;

    @FindBy(xpath = "//button[@id='closeBtn']")
    private WebElement closeBtn;

    @FindBy(xpath = "//button[@id='bookmarkBtn']" )
    private WebElement bookmarkBtn;

    @FindBy(xpath = "//button[@class='btn btn-o btn-bookmark btn-bookmark_in']" )
    private WebElement bookMarkTrue;

    @FindBy(xpath = "//button[@class='btn btn-o btn-bookmark btn-bookmark_out']" )
    private WebElement bookMarkFalse;


    public PurchasePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getProductID() {
        return productID;
    }

    public WebElement getSubmitBtn() {
        return submitBtn;
    }

    public WebElement getOrderAddedTitle() {
        return orderAddedTitle;
    }

    public WebElement getCloseBtn() {
        return closeBtn;
    }

    public WebElement getBookmarkBtn() {
        return bookmarkBtn;
    }

    public WebElement getBookMarkTrue() {
        return bookMarkTrue;
    }

    public WebElement getBookMarkFalse() {
        return bookMarkFalse;
    }
}
