package bean;

public class OrderProduct {

    private int orderId;
    private int productCode;
    private int quantity;

    public int getOrder() {
        return orderId;
    }

    public void setOrder(int order) {
        this.orderId = order;
    }

    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
