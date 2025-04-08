package com.jdbc.jdbc_second.pojo;

@SuppressWarnings("all")
public class Products {
    private String pid;
    private String pname;
    private String city;
    private Integer quantity;
    private Double price;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Products{" +
                "pid='" + pid + '\'' +
                ", pname='" + pname + '\'' +
                ", city='" + city + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
