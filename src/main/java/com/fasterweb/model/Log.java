package com.fasterweb.model;

public class Log {
    private Integer id;

    private String liushui;

    private Integer inId;

    private Integer outId;

    private Integer money;

    private String atime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInId() {
        return inId;
    }

    public Integer getOutId() {
        return outId;
    }

    public String getLiushui() {
        return liushui;
    }

    public void setLiushui(String liushui) {
        this.liushui = liushui;
    }

    public String getAaime() {
        return atime;
    }

    public void setInId(Integer inId ){
        this.inId = inId;
    }

    public void setOutId(Integer outId) {
        this.outId = outId;
    }

    public void setAtime(String atime)
    {
        this.atime = atime;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }
}
