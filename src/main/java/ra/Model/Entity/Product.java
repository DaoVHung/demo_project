package ra.Model.Entity;

public class Product {
    private int productID;
    private String catalogID;
    private String productName;
    private int price ;
    private String description;
    private boolean productStatus;
    private String productImg;
    private int orderID;

    private int discount;

    public Product() {
    }

    public Product(int productID, String catalogID, String productName, int price, String description, boolean productStatus, String productImg, int discount) {
        this.productID = productID;
        this.catalogID = catalogID;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.productStatus = productStatus;
        this.productImg = productImg;
        this.discount = discount;
    }

    public Product(int productID, String catalogID, String productName, int price, String description, boolean productStatus, String productImg, int orderID, int discount) {
        this.productID = productID;
        this.catalogID = catalogID;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.productStatus = productStatus;
        this.productImg = productImg;
        this.orderID = orderID;
        this.discount = discount;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getCatalogID() {
        return catalogID;
    }

    public void setCatalogID(String catalogID) {
        this.catalogID = catalogID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
