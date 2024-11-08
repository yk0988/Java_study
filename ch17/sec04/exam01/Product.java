package ch17.sec04.exam01;

public class Product {
    private int pno;
    private String name;
    private String company;
    private int price;

    public Product(int pno, String name, String company, int price) {
        this.pno = pno;
        this.name = name;
        this.company = company;
        this.price = price;
    }

    public int getPno() {
        return this.pno;
    }

    public String getName() {
        return this.name;
    }

    public String getCompany() {
        return this.company;
    }

    public int getPrice() {
        return this.price;
    }

    public String toString() {
        return "{" + "pno:" + this.pno + ", " + "name:" + this.name + ", " + "company:" + this.company + ", " + "price:" + this.price + "}";
    }
}
