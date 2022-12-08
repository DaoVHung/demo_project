package ra.Model.Entity;

public class OrderDetail {
    private int productID;
    private String productName;
    private int orderID;
    private int quantity;
    private int price;

    public OrderDetail() {
    }

    public OrderDetail(int productID, String productName, int orderID, int quantity, int price) {
        this.productID = productID;
        this.productName = productName;
        this.orderID = orderID;
        this.quantity = quantity;
        this.price = price;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
