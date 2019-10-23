package se.maetsskogfeldt.messaging;

import se.maetsskogfeldt.domain.Account;

import java.util.concurrent.BlockingDeque;

public class AccountProducer implements Runnable {
    private BlockingDeque<Account> accounts;
    private Long counter = 1L;

    public AccountProducer(BlockingDeque<Account> accounts){
        this.accounts = accounts;

    }

    @Override
    public void run(){
        while(!Thread.interrupted()) {
            try {
                accounts.add(Account.builder().withId(counter++).withBalance(100d).build());
            } catch (Exception e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }

}
