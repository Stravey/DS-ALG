package com.jdbc.jdbc_second.pojo;

@SuppressWarnings("all")
public class Agents {
    private String aid;
    private String aname;
    private String city;
    private Integer percent;

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getPercent() {
        return percent;
    }

    public void setPercent(Integer percent) {
        this.percent = percent;
    }

    @Override
    public String toString() {
        return "Agents{" +
                "aid='" + aid + '\'' +
                ", aname='" + aname + '\'' +
                ", city='" + city + '\'' +
                ", percent=" + percent +
                '}';
    }
}
