# banksystem

这是一个简单的转账系统设计， 采用了Spring+SpringMVC+MyBatis简单实现了一下功能。

`database.sql`是表结构的定义，主要有四张表

account_info：主要存储用户的基本信息，包括，表的自增id，账户id，姓名，密码，开户支行, 账户状态等

account: 资金账户, 主要有，自增id, 关联account_info的id，金额等

log: 记录操作的表, 主要有自增id，转入id, 转出id, 转移金额， 操作时间等

bank_info：银行基本信息，包括名字，位置等
