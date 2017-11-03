# banksystem

这是一个简单的转账系统设计， 采用了Spring+SpringMVC+MyBatis简单实现了一下功能。

`database.sql`是表结构的定义，主要有四张表

account_info：主要存储用户的基本信息，包括，表的自增id，账户id，姓名，密码，开户支行, 账户状态等

account: 资金账户, 主要有，自增id, 关联account_info的id，金额等

log: 记录操作的表, 主要有自增id，转入id, 转出id, 转移金额， 操作时间等

bank_info：银行基本信息，包括名字，位置等

对外的接口有三个：

1. 登录`\login`

2. 转账`\transfer`

3. 显示余额`\viewmoney`

比较重要的实现了您所需要的功能的有两个函数：

1. `BankController`里的`transfer`函数，对外提供转账操作，包括了调用了一些参数验证操作和事务性的转账操作

2. `AccountService`里的`transfer`，提供了转账操作的事务操作和流水记录操作
