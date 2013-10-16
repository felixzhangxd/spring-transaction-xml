package biz.ezcom.spring.transaction.service.api;

import biz.ezcom.spring.transaction.po.Account;

public interface IAccountService {
    void transfer(Integer fromAccountId, Integer toAccountId, Double money) throws Throwable;
    void doTransfer(Account fromAccount, Account toAccount, Double money) throws Throwable;
    void payServiceFee(Account account, Double money) throws Throwable;
}
