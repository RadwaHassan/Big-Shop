package bean;

import java.util.ArrayList;
import java.util.Date;

public class Order {

    private Date date;
    private int id;
    private ArrayList<OrderProduct> products;

    public Order() {

    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<OrderProduct> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<OrderProduct> products) {
        this.products = products;
    }

}
