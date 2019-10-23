package se.maetsskogfeldt.domain;

import org.junit.Assert;
import org.junit.Test;
import se.maetsskogfeldt.domain.Account;

public class AccountTest {
    @Test
    public void accountTest(){
        Account account = new Account.Builder().withId(1L).withBalance(10000D).build();
        Assert.assertEquals(Double.valueOf(10000d),account.getBalance());
    }
}
