package se.maetsskogfeldt.messaging;

import org.junit.Test;
import se.maetsskogfeldt.dao.AccountDaoImpl;
import se.maetsskogfeldt.domain.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class AccountListenerTest {

    @Test
    public void messagingTest() throws InterruptedException{
        BlockingDeque<Account> accounts = new LinkedBlockingDeque<>();

        AccountProducer accountProducer = new AccountProducer(accounts);

        List<AccountListener> accountListeners = new ArrayList<>();

        accountListeners.add(account -> System.out.println(account));
        accountListeners.add(new AccountListenerImpl(new AccountDaoImpl()));
        accountListeners.add(account -> System.out.println(account.getBalance()));

        AccountConsumer accountConsumer = new AccountConsumer(accounts, accountListeners);

        new Thread(accountProducer).start();
        new Thread(accountConsumer).start();

        Thread.sleep(5000);
    }
}
