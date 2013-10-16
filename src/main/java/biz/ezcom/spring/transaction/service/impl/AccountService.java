package biz.ezcom.spring.transaction.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import biz.ezcom.spring.transaction.dao.api.IAccountDao;
import biz.ezcom.spring.transaction.exception.OverdrawException;
import biz.ezcom.spring.transaction.po.Account;
import biz.ezcom.spring.transaction.service.api.IAccountService;

@Service
public class AccountService implements IAccountService {
    @Resource
    private IAccountService accountService;
    @Resource
    private IAccountDao     accountDao;

    @Override
    public void transfer(Integer fromAccountId, Integer toAccountId, Double money) throws Throwable {
        Account fromAccount = accountDao.find(fromAccountId);
        Account toAccount = accountDao.find(toAccountId);
        accountService.doTransfer(fromAccount, toAccount, money);
    }

    @Override
    public void doTransfer(Account fromAccount, Account toAccount, Double money) throws Throwable {
        Double fromBalance = fromAccount.getBalance() - money;
        if(fromBalance < 0) {
            throw new OverdrawException("交易金额透支异常");
        }
        fromAccount.setBalance(fromBalance);
        Double toBalance = toAccount.getBalance() + money;
        toAccount.setBalance(toBalance);
        accountDao.modify(fromAccount);
        accountDao.modify(toAccount);
        
        accountService.payServiceFee(toAccount, money);
        accountService.payServiceFee(fromAccount, money);
    }

    @Override
    public void payServiceFee(Account account, Double money) throws Throwable {
        Double balance = account.getBalance() - money / 100;
        if(balance < 0) {
            throw new OverdrawException("支付银行手续费透支异常");
        }
        account.setBalance(balance);
        accountDao.modify(account);
    }
}
