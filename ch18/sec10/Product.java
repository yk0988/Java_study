package ch18.sec10;

import java.io.Serializable;

class Product implements Serializable {
    private String productName;
    private int price;

    public Product(String productName, int price) {
        this.productName = productName;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{productName='" + productName + "', price=" + price + "}";
    }
}