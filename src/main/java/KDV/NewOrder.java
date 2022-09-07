package KDV;

public class NewOrder {
    private String vendorCode;
    private String title;
    private String href;
    private int quantity;
    private int ordered;

    public NewOrder(String vendorCode, String title, String href, int quantity) {
        this.vendorCode = vendorCode;
        this.title = title;
        this.href = href;
        this.quantity = quantity;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setOrdered(int ordered) {
        this.ordered = ordered;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "NewOrder{" +
                "vendorCode='" + vendorCode + '\'' +
                ", title='" + title + '\'' +
                ", href='" + href + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
