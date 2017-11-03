package com.fasterweb.model;

public class LoginForm {
    private Integer accountId;

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getAccountId() {
        return accountId;
    }
}
