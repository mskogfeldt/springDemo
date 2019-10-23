package se.maetsskogfeldt.service;

import se.maetsskogfeldt.dao.AccountDao;
import se.maetsskogfeldt.dao.AccountDaoImpl;
import se.maetsskogfeldt.domain.Account;

public class ServiceFactoryImpl implements ServiceFactory {

    @Override
    public AccountService createAccountService() {
        AccountDao accountDao = new AccountDaoImpl();
        accountDao.create(new Account.Builder().withId(1L).withBalance(10000d).build());
        return new AccountServiceImpl(accountDao);
    }
}
