package com.fasterweb.service;

import com.fasterweb.dao.AccountInfoMapper;
import com.fasterweb.model.AccountInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("AccountInfoService")
public class AccountInfoService {

    @Resource
    private AccountInfoMapper accountInfoMapper;

    /**
     *
     * @param accountId
     * @param aname
     * @return
     * @decription 验证账户是否存在和有效，可能存在账户冻结的情况
     */
    public boolean validAccount(Integer accountId, String aname){
        AccountInfo accountInfo = accountInfoMapper.getAccountInfoByAccountIdAndAname(accountId,aname);
        if(accountInfo == null || accountInfo.getStatus() == 1){
            return false;
        }

        return true;
    }

    /**
     *
     * @param accountId
     * @param password
     * @return
     * @description 登录功能，验证账户名和密码
     */
    public boolean login(Integer accountId, String password){
        AccountInfo accountInfo = accountInfoMapper.getAccountInfoByAccountIdAndPassword(accountId,password);
        if(accountInfo == null){
            return false;

        }

        return true;
    }

    /**
     *
     * @param accountId
     * @return
     *@description 返回账户信息
     */
    public AccountInfo getAccountinfoByAccountId(Integer accountId){
        return accountInfoMapper.getAcountInfoByAccountId(accountId);
    }
}

