package com.fasterweb.dao;

import com.fasterweb.model.Account;

import org.mybatis.spring.annotation.MapperScan;

@MapperScan
public interface AccountMapper {

    Account getAccountById(Integer id);

    Account getAcountByAccountInfoId(Integer accountInfoId);

    void udpateAccount(Account account);

}

