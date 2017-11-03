package com.fasterweb.model;

public class Account {

    private Integer id;

    private Integer accountInfoId;

    private Integer money;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Integer getMoney() {
        return money;
    }

    public Integer getAccountInfoId() {
        return accountInfoId;
    }

    public void setAccountInfoId(Integer accountInfoId) {
        this.accountInfoId = accountInfoId;
    }
}
