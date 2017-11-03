package com.fasterweb.model;

public class TransferForm {

    private String liushui;

    private Integer inId;

    private Integer outId;

    private Integer money;

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Integer getMoney() {
        return money;
    }

    public void setOutId(Integer outId) {
        this.outId = outId;
    }

    public void setLiushui(String liushui) {
        this.liushui = liushui;
    }

    public String getLiushui() {
        return liushui;
    }

    public Integer getOutId() {
        return outId;
    }

    public Integer getInId() {
        return inId;
    }

    public void setInId(Integer inId) {
        this.inId = inId;
    }
}
