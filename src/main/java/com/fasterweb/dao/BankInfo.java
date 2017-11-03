package com.fasterweb.dao;

public class BankInfo {

    private Integer id;

    private String bankName;

    private String location;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBankName() {
        return bankName;
    }

    public String getLocation() {
        return location;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
