package biz.ezcom.spring.transaction.dao.api;

import biz.ezcom.spring.transaction.po.Account;

public interface IAccountDao {
    void save(Account account);

    void remove(Integer id);

    void modify(Account account);

    Account find(Integer id);
}
