package com.jdbc.jdbc_second.pojo;

@SuppressWarnings("all")
public class Orders {
    private Integer ordno;
    private String month;
    private String cid;
    private String aid;
    private String pid;
    private Integer qty;
    private Double dollars;

    public Integer getOrdno() {
        return ordno;
    }

    public void setOrdno(Integer ordno) {
        this.ordno = ordno;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Double getDollars() {
        return dollars;
    }

    public void setDollars(Double dollars) {
        this.dollars = dollars;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "ordno=" + ordno +
                ", month='" + month + '\'' +
                ", cid='" + cid + '\'' +
                ", aid='" + aid + '\'' +
                ", pid='" + pid + '\'' +
                ", qty=" + qty +
                ", dollars=" + dollars +
                '}';
    }
}
