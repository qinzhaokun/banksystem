# banksystem

这是一个简单的转账系统设计， 采用了Spring+SpringMVC+MyBatis简单实现了一下功能。

`database.sql`是表结构的定义，主要有四张表

account_info：主要存储用户的基本信息，包括，表的自增id，账户id，姓名，密码，开户支行, 账户状态等

account: 资金账户, 主要有，自增id, 关联account_info的id，金额等

log: 记录操作的表, 主要有自增id，转入id, 转出id, 转移金额， 操作时间等

bank_info：银行基本信息，包括名字，位置等

对外的接口有三个：

1. 登录`\login`

2. 转账`\transfer`, 转账之前必须登录

3. 显示余额`\viewmoney` 显示前必须登录

比较重要的实现了您所需要的功能的有两个函数：

1. `BankController`里的`transfer`函数，对外提供转账操作，包括了调用了一些参数验证操作和事务性的转账操作

2. `AccountService`里的`transfer`，提供了**转账操作的事务操作**和流水记录操作

此外，相比昨天，加上了对转账金额有效性的判断。更多接口的细节可以看看注释。

要求说明:
1. 不能透支。提供了`validYue`接口保证不会透支

2. 保证转账金额计算准确。提供了`jiaoyan`接口保证转账前后数据库的数据一致性

3. 每天10万笔。使用springMVC 处理请求使用单例多线程的，保证了一定的并发性.
