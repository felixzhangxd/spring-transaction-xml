package biz.ezcom.spring.transaction.dao.impl;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import biz.ezcom.spring.transaction.dao.api.IAccountDao;
import biz.ezcom.spring.transaction.po.Account;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-*.xml")
public class AccountDaoTest {
    @Resource
    private IAccountDao accountDao;

    @Test
    public void testSave() {
        accountDao.save(new Account(null,"Felix", "pwd", 10000D));
        accountDao.save(new Account(null,"Justin", "pw", 0D));
    }
}
