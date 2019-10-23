package se.maetsskogfeldt.messaging;

import se.maetsskogfeldt.domain.Account;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

public class AccountConsumer implements Runnable{
    private BlockingDeque<Account> accounts;

    private List<AccountListener> accountListeners = new CopyOnWriteArrayList();

    AccountConsumer(BlockingDeque<Account> accounts,
                    List<AccountListener> accountListeners) {
        this.accounts = Objects.requireNonNull(accounts, "accounts may not be null");
        this.accountListeners.addAll(Objects.requireNonNull(accountListeners, "AccountDao cannot be null"));

    }
    @Override
    public void run(){
        while(!Thread.interrupted()) {
            try {
                Account account = accounts.poll(100L, TimeUnit.MILLISECONDS);
                if(account != null) {
                    accountListeners.forEach(al -> al.onAccount(account));
                }
            }
            catch (InterruptedException e) {
                Thread.interrupted();
            }
        }
    }

    public static class RunningTask {}
}
