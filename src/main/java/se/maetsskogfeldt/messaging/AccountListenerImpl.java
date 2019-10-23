package se.maetsskogfeldt.messaging;

import se.maetsskogfeldt.dao.AccountDao;
import se.maetsskogfeldt.domain.Account;

import java.util.Objects;

public class AccountListenerImpl implements AccountListener {

    // only declaration will be initiaged via the constructor
    private AccountDao accountDao;


    public AccountListenerImpl(AccountDao accountDao){
        this.accountDao = Objects.requireNonNull(accountDao, "accountDau ma not be null");
    }

    @Override
    public void onAccount(Account account){
        accountDao.create(account);
    }
}
