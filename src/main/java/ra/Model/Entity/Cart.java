package ra.Model.Entity;

public class Cart {
    private Product product;
    private int quantity;
    private int discount;
    private String note;

    public Cart() {
    }

    public Cart(Product product, int quantity, int discount, String note) {
        this.product = product;
        this.quantity = quantity;
        this.discount = discount;
        this.note = note;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
