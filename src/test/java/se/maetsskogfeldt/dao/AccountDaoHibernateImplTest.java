package se.maetsskogfeldt.dao;

import org.junit.Assert;
import org.junit.Test;
import se.maetsskogfeldt.domain.Account;

import java.util.Optional;

public class AccountDaoHibernateImplTest {


    @Test
    public void addAccountToDatabaseTest() {
        AccountDao dao = new AccountDaoHibernateImpl();
        Account account = Account.builder().withId(24L).withBalance(15000d).build();
        dao.create(account);
        //Assert.assertEquals(Long.valueOf(20L), dao.read(20L).get().getId());
    }

    @Test
    public void getAccountTest(){
        AccountDao dao = new AccountDaoHibernateImpl();
        Optional<Account> optional = dao.read(13L);
        Assert.assertEquals(Long.valueOf(13L),optional.get().getId());

    }


}
