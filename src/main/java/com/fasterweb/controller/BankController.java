package com.fasterweb.controller;

import com.fasterweb.model.Account;
import com.fasterweb.model.AccountInfo;
import com.fasterweb.model.LoginForm;
import com.fasterweb.model.TransferForm;
import com.fasterweb.service.AccountInfoService;
import com.fasterweb.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BankController {

    @Autowired
    private AccountInfoService accountInfoService;

    @Autowired
    private AccountService accountService;

    @RequestMapping("/login")
    @ResponseBody
    public String login(@RequestBody LoginForm loginForm){
        if(accountInfoService.login(loginForm.getAccountId(),loginForm.getPassword())){
            return "success";
        }
        else{
            return "error";
        }
    }

    /**
     *
     * @param transferForm
     * @return
     * @description 转账的核心接口
     */

    @RequestMapping("/transfer")
    @ResponseBody
    public String transfer(@RequestBody TransferForm transferForm) throws Exception{

        //判断金额的有效性
        if(transferForm.getMoney() <= 0 || transferForm.getMoney() > 10000000){
            return "非法金额";
        }

        //拿到转入账户的信息
        AccountInfo accountInfoIn = accountInfoService.getAccountinfoByAccountId(transferForm.getInId());

        if(accountInfoIn == null){
            return "转入账户不存在";
        }
        boolean flag;

        //判断账户是否异常
        flag = accountInfoService.validAccount(accountInfoIn.getAccountId(), accountInfoIn.getAname());

        if(!flag){
            return "转入账户账户名和姓名不匹配，或该账户异常";
        }

        //得到转入的存款账户
        Account accountIn = accountService.getAccountByAccountId(accountInfoIn.getAccountId());


        //拿到转入账户
        AccountInfo accountInfoOut = accountInfoService.getAccountinfoByAccountId(transferForm.getOutId());

        //由于已经登录了，所以转出账户一定存在

        //拿到转出账户存款账户
        Account accountOut = accountService.getAccountByAccountId(accountInfoOut.getAccountId());

        //判断是否超过余额
        flag = accountService.validYue(transferForm.getMoney(), accountOut.getId());

        if(!flag){
            return "余额不足";
        }

        flag = accountService.transfer(accountIn,accountOut,transferForm.getLiushui(), transferForm.getMoney());

        if(!flag){
            return "失败";
        }

        return "成功";
    }

    @RequestMapping("/viemmoney")
    @ResponseBody
    public String viewMoney(@RequestBody Integer accountId){
        Account account = accountService.getAccountByAccountId(accountId);
        if(account == null){
            return "账户不存在";

        }

        return account.getMoney().toString();
    }


}
