package com.fasterweb.dao;

import com.fasterweb.model.AccountInfo;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

@MapperScan
public interface AccountInfoMapper {

    AccountInfo getAccountInfoById(Integer id);

    AccountInfo getAcountInfoByAccountId(Integer AccountId);

    AccountInfo getAccountInfoByAccountIdAndPassword(@Param("accountId")Integer AccountId, @Param("password")String password);

    AccountInfo getAccountInfoByAccountIdAndAname(@Param("accountId")Integer accountId, @Param("aname")String aname);
}
