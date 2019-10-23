package se.maetsskogfeldt.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import se.maetsskogfeldt.dao.AccountDao;
import se.maetsskogfeldt.dao.AccountDaoImpl;
import se.maetsskogfeldt.domain.Account;

import java.util.Collection;

public class AccountDaoTest {
    private AccountDao dao;
    private Account account1;
    private Account account2;

    @Before
    public void initTest(){
        dao = new AccountDaoImpl();
        account1 = new Account.Builder().withId(2L).withBalance(20000d).build();
        account2 = new Account.Builder().withId(1L).withBalance(20000d).build();

        dao.create(account1);
        dao.create(account2);

    }

    @Test
    public void createTest(){
        Account fetchedAccount = dao.getAccounts().get(1L);
        Assert.assertEquals(Double.valueOf(20000d), fetchedAccount.getBalance());
    }

    @Test
    public void readTest(){
        Assert.assertEquals(dao.read(2L).get(), account1);
        Assert.assertEquals(dao.read(1L).get(), account2);
    }

    @Test
    public void readAccountsWithBalanceOver(){
        Collection<Account> result = dao.readAccountsWithBalanceOver(19000D);
        result.forEach(System.out::println);
        Assert.assertTrue(result.contains(account1));
    }
}


