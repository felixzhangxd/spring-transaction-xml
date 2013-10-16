package biz.ezcom.spring.transaction.service.impl;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import biz.ezcom.spring.transaction.service.api.IAccountService;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-*.xml")
public class AccountServiceTest {
    @Resource
    private IAccountService accountService;

    @Test
    public void testTransfer() throws Throwable {
        accountService.transfer(1, 2, 100D);
//        accountService.transfer(1, 2, 100000D);
    }
}
