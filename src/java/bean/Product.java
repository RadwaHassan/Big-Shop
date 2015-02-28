package bean;

import static com.sun.org.apache.bcel.internal.Repository.instanceOf;

public class Product {

    private int code;
    private String description;
    private String imagePath;
    private String name;
    private float price;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int hashCode() {
        return 1;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof Product) && ((Product) obj).getCode() == this.code) {
            return true;
        } else {

            return false;
        }
    }

}
