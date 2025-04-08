package com.jdbc.jdbc_first.pojo;

import java.util.Objects;

public class Orders {
    int old;
    double price;
    int payType;

    public Orders() {

    }

    public Orders(int old, int payType, double price) {
        this.old = old;
        this.payType = payType;
        this.price = price;
    }

    public int getOld() {
        return old;
    }

    public void setOld(int old) {
        this.old = old;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPayType() {
        return payType;
    }

    public void setPayType(int payType) {
        this.payType = payType;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "old=" + old +
                ", price=" + price +
                ", payType=" + payType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return old == orders.old && Double.compare(price, orders.price) == 0 && payType == orders.payType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(old, price, payType);
    }
}
