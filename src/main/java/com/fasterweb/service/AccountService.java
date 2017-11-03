package com.fasterweb.service;

import com.fasterweb.dao.AccountMapper;
import com.fasterweb.model.Account;
import com.fasterweb.model.Log;
import com.fasterweb.model.TransferForm;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

@Service("AccountService")
public class AccountService {

    @Resource
    private AccountMapper accountMapper;

    @Resource
    private LogService logService;

    public Account getAccountByAccountId(Integer accountId){
        return accountMapper.getAcountByAccountId(accountId);
    }

    public Account getAccountById(Integer id){
        return accountMapper.getAccountById(id);
    }


    /**
     *
     * @param account
     * @dedcription 更新一个账户的余额，用于执行转账操作的接口
     */
    @Transactional
    public void updateAccount(Account account){
        accountMapper.udpateAccount(account);
    }

    /**
     *
     * @param money
     * @param id
     * @return
     * @description 验证转出余额是否小于账户余额
     */

    public boolean validYue(Integer money, Integer id){
        Account account = getAccountById(id);
        if(account == null){
            return false;
        }

        if(account.getMoney() < money){
            return false;
        }

        return true;
    }

    /**
     *
     * @param in_id
     * @param out_id
     * @return
     * @throws Exception
     * @deccription 计算两个账户的余额总额，为之后校验使用
     */
    public Integer getTotalMoney(Integer in_id, Integer out_id) throws Exception{
        Account account1 = getAccountById(in_id);
        Account account2 = getAccountById(out_id);
        if(account1 == null || account2 == null){
            throw new Exception("account is not exist!");
        }
        else{
            return account1.getMoney() + account2.getMoney();
        }
    }

    /**
     *
     * @param totalMoney
     * @param in_id
     * @param out_id
     * @return
     * @description 校验转账前后余额总和是否和转账前相同，其实这里应该把转账前的终于存入新的数据库中表中再执行下面的操作，防止转账过程中机器宕机
     */

    public boolean jiaoyan(Integer totalMoney, Integer in_id, Integer out_id){
        //这里的查询要禁用缓存
        Account account1 = getAccountByAccountId(in_id);
        Account account2 = getAccountByAccountId(out_id);
        if(account1 == null || account2 == null){
            return false;
        }

        if(totalMoney == account1.getMoney() + account2.getMoney()){
            return true;
        }
        else{
            return false;
        }
    }


    /**
     *
     * @param accountIn
     * @param accountOut
     * @param liushui
     * @param money
     * @return
     * @throws Exception
     * @description 执行转账的重要步骤，具有原子性,提供事务的保障
     */
    @Transactional
    public boolean transfer(Account accountIn, Account accountOut, String liushui, Integer money) throws Exception{
        Integer TotalMoneyBefore = 0;
        try{
            TotalMoneyBefore = getTotalMoney(accountIn.getId(), accountOut.getId());
        }catch (Exception e){
            throw e;
        }

        accountOut.setMoney(accountOut.getMoney() - money);
        accountIn.setMoney(accountIn.getMoney() + money);

        updateAccount(accountIn);

        updateAccount(accountOut);

        boolean flag = jiaoyan(TotalMoneyBefore, accountIn.getId(), accountOut.getId());

        //校验失败，抛出异常，回滚
        if(!flag){
            throw new Exception("校验失败");
        }

        //最后一步，记录操作流水
        Log log = new Log();
        log.setInId(accountIn.getId());
        log.setOutId(accountOut.getId());
        log.setLiushui(liushui);
        log.setAtime((new Date()).toString());
        logService.addLog(log);
        return true;
    }
}
