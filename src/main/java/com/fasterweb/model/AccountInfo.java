package com.fasterweb.model;

public class AccountInfo {

    private Integer id;

    private Integer accountId;

    private String password;

    private String aname;

    private Integer bankId;

    private Integer status;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }



    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public Integer getBankId() {
        return bankId;
    }



    public void setBankId(Integer bank_id) {
        this.bankId = bank_id;
    }

    public Integer getStatus() {
        return status;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}

