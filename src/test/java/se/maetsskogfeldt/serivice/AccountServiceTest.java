package se.maetsskogfeldt.serivice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import se.maetsskogfeldt.dao.AccountDao;
import se.maetsskogfeldt.dao.AccountDaoImpl;
import se.maetsskogfeldt.domain.Account;
import se.maetsskogfeldt.service.AccountService;
import se.maetsskogfeldt.service.AccountServiceImpl;

public class AccountServiceTest {

    @Test
    public void testGetBallance() {
        AccountDao accountDao = new AccountDaoImpl();
        AccountService accountServiceImpl = new AccountServiceImpl(accountDao);
        accountDao.create(new Account.Builder().withId(1L).withBalance(30000D).build());
        accountDao.create(new Account.Builder().withId(2L).withBalance(29000D).build());
        accountDao.create(new Account.Builder().withId(3L).withBalance(20000D).build());
        Double balance = accountServiceImpl.getBalance(1L);
        accountServiceImpl.getBalance(2L);
        Assert.assertEquals(Double.valueOf(30000D),balance);
    }


}
